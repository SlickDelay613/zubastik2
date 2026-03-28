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
import service.ClaimService;
import service.CustomerService;
import service.PremiumCalculationService;
import service.ReportService;
import service.impl.ClaimServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.PremiumCalculationServiceImpl;
import service.impl.ReportServiceImpl;
import strategy.*;
import strategy.impl.CarPayoutStrategy;
import strategy.impl.HealthPayoutStrategy;
import strategy.impl.PayoutCalculationStrategyRegistry;
import strategy.impl.PropertyPayoutStrategy;

import java.util.Collection;

public class UserController {
    private final PolicyDao policyDao;
    private final ClaimDao claimDao;
    private final ClaimService claimService;
    private final CustomerService customerService;
    private final PremiumCalculationService premiumCalculator;
    private final ReportService reportService;
    private final PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry;
    private final PolicyFactoryRegistry factoryRegistry;

    public UserController(PolicyDao policyDao, ClaimDao claimDao,
                          ClaimService claimService, CustomerService customerService,
                          PremiumCalculationService premiumCalculator, ReportService reportService, PolicyFactoryRegistry factoryRegistry,
                          PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry) {
        this.policyDao = policyDao;
        this.claimDao = claimDao;
        this.claimService = claimService;
        this.customerService = customerService;
        this.premiumCalculator = premiumCalculator;
        this.reportService = reportService;
        this.factoryRegistry = factoryRegistry;
        this.payoutCalculationStrategyRegistry = payoutCalculationStrategyRegistry;
    }

    public static UserController create() {
        PolicyDao policyDao = new PolicyDaoImpl(new PolicyRepositoryImpl());
        ClaimDao claimDao = new ClaimDaoImpl(new ClaimRepositoryImpl());

        PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry = new PayoutCalculationStrategyRegistry();
        payoutCalculationStrategyRegistry.register(new CarPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new PropertyPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new HealthPayoutStrategy());

        PolicyFactoryRegistry registry = new PolicyFactoryRegistry();
        registry.register(new CarPolicyFactory());
        registry.register(new HealthPolicyFactory());
        registry.register(new PropertyPolicyFactory());

        return new UserController(
                policyDao,
                claimDao,
                new ClaimServiceImpl(),
                new CustomerServiceImpl(),
                new PremiumCalculationServiceImpl(),
                new ReportServiceImpl(),
                registry,
                payoutCalculationStrategyRegistry
        );
    }

    public PolicyDto createPolicy(String customerName, double coverageAmount, double baseRatePercent, String policyType) {
        CustomerDto customer = customerService.createCustomer(customerName);
        double premium = premiumCalculator.calculatePremium(coverageAmount, baseRatePercent);
        PolicyType ptype = PolicyDecipher.decipher(policyType);
        PolicyFactory factory = factoryRegistry.getFactory(ptype);
        PolicyDto policy = factory.createPolicy(customer, coverageAmount, premium);
        policyDao.save(policy);
        //создать сервис с сохранением и созданием
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
