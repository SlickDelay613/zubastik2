package controller;

import dao.ClaimDao;
import dao.PolicyDao;
import dao.impl.ClaimDaoImpl;
import dao.impl.PolicyDaoImpl;
import helper.PolicyType;
import model.ClaimDto;
import model.CustomerDto;
import model.PolicyDto;
import repository.impl.ClaimRepositoryImpl;
import repository.impl.PolicyRepositoryImpl;
import service.*;
import service.impl.*;
import java.util.Collection;
import app_grpc.client.ReferenceGrpcClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserController {
    private final PolicyDao policyDao;
    private final ClaimDao claimDao;
    private final PolicyService policyService;
    private final ClaimService claimService;
    private final CustomerService customerService;
    private final ReferenceGrpcClient grpcClient;
    private final ReportService reportService;

    public UserController(PolicyDao policyDao, ClaimDao claimDao,
                          ClaimService claimService, CustomerService customerService,
                          ReferenceGrpcClient grpcClient, ReportService reportService,
                          PolicyService policyService) {
        this.policyDao = policyDao;
        this.claimDao = claimDao;
        this.claimService = claimService;
        this.customerService = customerService;
        this.grpcClient = grpcClient;
        this.reportService = reportService;
        this.policyService = policyService;
    }

    public static UserController create() {
        PolicyDao policyDao = new PolicyDaoImpl(new PolicyRepositoryImpl());
        ClaimDao claimDao = new ClaimDaoImpl(new ClaimRepositoryImpl());

        // Подключаемся к микросервису B
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        ReferenceGrpcClient grpcClient = new ReferenceGrpcClient(channel);

        return new UserController(
                policyDao,
                claimDao,
                new ClaimServiceImpl(claimDao, grpcClient),
                new CustomerServiceImpl(grpcClient),
                grpcClient,
                new ReportServiceImpl(),
                new PolicyServiceImpl(policyDao, grpcClient)
        );
    }

    public PolicyDto createPolicy(String customerName, double coverageAmount, double baseRatePercent, String policyType) {
        CustomerDto customer = customerService.createCustomer(customerName);
        double premium = grpcClient.calculatePremium(coverageAmount, baseRatePercent);
        PolicyType ptype = grpcClient.resolveType(policyType);
        return policyService.createPolicy(customer, coverageAmount, premium, ptype);
    }

    public Collection<PolicyDto> getAllPolicies() { return policyDao.findAll(); }
    public Collection<ClaimDto> getAllClaims() { return claimDao.findAll(); }

    public ClaimDto registerClaim(String policyNumber, double damageAmount) {
        PolicyDto policy = policyDao.findByNumber(policyNumber);
        return claimService.createClaim(policy, damageAmount);
    }

    public void processClaim(String claimId, boolean approve) { claimService.processClaim(claimId, approve); }
    public String generatePayoutReport() { return reportService.buildPayoutReport(claimDao.findAll()); }
}