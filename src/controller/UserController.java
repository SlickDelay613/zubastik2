package controller;

import dao.ClaimDao;
import dao.PolicyDao;
import helper.PolicyDecipher;
import dao.impl.ClaimDaoImpl;
import dao.impl.PolicyDaoImpl;
import factory.*;
import factory.impl.CarPolicyFactory;
import factory.impl.HealthPolicyFactory;
import factory.impl.PolicyFactoryRegistry;
import factory.impl.PropertyPolicyFactory;
import helper.PolicyType;
import model.ClaimDto;
import model.CustomerDto;
import model.PolicyDto;
import repository.impl.ClaimRepositoryImpl;
import repository.impl.PolicyRepositoryImpl;
import service.*;
import service.impl.*;
import strategy.*;
import strategy.impl.CarPayoutStrategy;
import strategy.impl.HealthPayoutStrategy;
import strategy.impl.PayoutCalculationStrategyRegistry;
import strategy.impl.PropertyPayoutStrategy;

import java.util.Collection;

public class UserController {
    private final PolicyDao policyDao;
    private final ClaimDao claimDao;
    private final PolicyService policyService;
    private final ClaimService claimService;
    private final CustomerService customerService;
    private final PremiumCalculationService premiumCalculator;
    private final ReportService reportService;
    private final PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry;

    public UserController(PolicyDao policyDao, ClaimDao claimDao,
                          ClaimService claimService, CustomerService customerService,
                          PremiumCalculationService premiumCalculator, ReportService reportService,
                          PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry, PolicyService policyService) {
        this.policyDao = policyDao;
        this.claimDao = claimDao;
        this.claimService = claimService;
        this.customerService = customerService;
        this.premiumCalculator = premiumCalculator;
        this.reportService = reportService;
        this.payoutCalculationStrategyRegistry = payoutCalculationStrategyRegistry;
        this.policyService = policyService;
    }

    public static UserController create() {
        PolicyDao policyDao = new PolicyDaoImpl(new PolicyRepositoryImpl());
        ClaimDao claimDao = new ClaimDaoImpl(new ClaimRepositoryImpl());

        PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry = new PayoutCalculationStrategyRegistry();
        payoutCalculationStrategyRegistry.register(new CarPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new PropertyPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new HealthPayoutStrategy());

        return new UserController(
                policyDao,
                claimDao,
                new ClaimServiceImpl(),
                new CustomerServiceImpl(),
                new PremiumCalculationServiceImpl(),
                new ReportServiceImpl(),
                payoutCalculationStrategyRegistry,
                new PolicyServiceImpl(policyDao)
        );
    }

    public PolicyDto createPolicy(String customerName, double coverageAmount, double baseRatePercent, String policyType) {
        CustomerDto customer = customerService.createCustomer(customerName);
        double premium = premiumCalculator.calculatePremium(coverageAmount, baseRatePercent);
        PolicyType ptype = PolicyDecipher.decipher(policyType);
        return policyService.createPolicy(customer, coverageAmount, premium, ptype);
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
            PolicyType policyType = claim.getPolicy().getPolicyType();
            PayoutCalculationStrategy strategy = payoutCalculationStrategyRegistry.getStrategy(policyType);
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
