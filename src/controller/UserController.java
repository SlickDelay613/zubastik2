package controller;

import dao.ClaimDao;
import dao.PolicyDao;
import dao.impl.ClaimDaoImpl;
import dao.impl.PolicyDaoImpl;
import factory.*;
import model.ClaimDto;
import model.CustomerDto;
import model.PolicyDto;
import lombok.RequiredArgsConstructor;
import repository.impl.ClaimRepositoryImpl;
import repository.impl.PolicyRepositoryImpl;
import service.ClaimService;
import service.CustomerService;
import service.PolicyService;
import service.PremiumCalculationService;
import service.ReportService;
import service.impl.ClaimServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.PolicyServiceImpl;
import service.impl.PremiumCalculationServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.CarPayoutStrategy;
import strategy.HealthPayoutStrategy;
import strategy.PayoutCalculationStrategy;
import strategy.PropertyPayoutStrategy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserController {
    private final PolicyDao policyDao;
    private final ClaimDao claimDao;
    private final PolicyService policyService;
    private final ClaimService claimService;
    private final CustomerService customerService;
    private final PremiumCalculationService premiumCalculator;
    private final ReportService reportService;
    private final Map<String, PayoutCalculationStrategy> payoutStrategies;
    private final PolicyFactoryRegistry factoryRegistry;

    public UserController(PolicyDao policyDao, ClaimDao claimDao, PolicyService policyService,
                          ClaimService claimService, CustomerService customerService,
                          PremiumCalculationService premiumCalculator, ReportService reportService, PolicyFactoryRegistry factoryRegistry) {
        this.policyDao = policyDao;
        this.claimDao = claimDao;
        this.policyService = policyService;
        this.claimService = claimService;
        this.customerService = customerService;
        this.premiumCalculator = premiumCalculator;
        this.reportService = reportService;
        this.factoryRegistry = factoryRegistry;
        this.payoutStrategies = new HashMap<>();
        payoutStrategies.put("АВТО", new CarPayoutStrategy());
        payoutStrategies.put("ЗДОР", new HealthPayoutStrategy());
        payoutStrategies.put("НЕДВИЖ", new PropertyPayoutStrategy());
    }

    public static UserController create() {
        PolicyDao policyDao = new PolicyDaoImpl(new PolicyRepositoryImpl());
        ClaimDao claimDao = new ClaimDaoImpl(new ClaimRepositoryImpl());

        PolicyFactoryRegistry registry = new PolicyFactoryRegistry();
        registry.register(new CarPolicyFactory());
        registry.register(new HealthPolicyFactory());
        registry.register(new PropertyPolicyFactory());

        return new UserController(
                policyDao,
                claimDao,
                new PolicyServiceImpl(),
                new ClaimServiceImpl(),
                new CustomerServiceImpl(),
                new PremiumCalculationServiceImpl(),
                new ReportServiceImpl(),
                registry
        );
    }

    public PolicyDto createPolicy(String customerName, double coverageAmount, double baseRatePercent, String policyType) {
        CustomerDto customer = customerService.createCustomer(customerName);
        double premium = premiumCalculator.calculatePremium(coverageAmount, baseRatePercent);
        PolicyFactory factory = factoryRegistry.getFactory(policyType);
        PolicyDto policy = factory.createPolicy(customer, coverageAmount, premium);
        policyDao.save(policy);
        return policy;
    }

    public Collection<PolicyDto> getAllPolicies() {
        return policyDao.findAll();
    }

    public Collection<ClaimDto> getAllClaims() {
        return claimDao.findAll();
    }

    public ClaimDto registerClaim(String policyNumber, double damageAmount) {
        PolicyDto policy = policyDao.findByNumber(policyNumber);
        ClaimDto claim = claimService.createClaim(policy, damageAmount);
        claimDao.save(claim);
        return claim;
    }

    public void processClaim(String claimId, boolean approve) {
        ClaimDto claim = claimDao.findById(claimId);
        if (approve) {
            String policyType = claim.getPolicy().getPolicyType();
            PayoutCalculationStrategy strategy = payoutStrategies.getOrDefault(policyType, new CarPayoutStrategy());
            double payoutAmount = strategy.calculatePayout(claim);
            claimService.approve(claim, payoutAmount);
            claimService.markAsPaid(claim);
        } else {
            claimService.reject(claim);
        }
        claimDao.save(claim);
    }

    public String generatePayoutReport() {
        return reportService.buildPayoutReport(claimDao.findAll());
    }
}
