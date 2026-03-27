package controller;

import dao.ClaimDao;
import dao.PolicyDao;
import dao.impl.ClaimDaoImpl;
import dao.impl.PolicyDaoImpl;
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

import java.util.Collection;

@RequiredArgsConstructor
public class UserController {
    private final PolicyDao policyDao;
    private final ClaimDao claimDao;
    private final PolicyService policyService;
    private final ClaimService claimService;
    private final CustomerService customerService;
    private final PremiumCalculationService premiumCalculator;
    private final ReportService reportService;

    public static UserController create() {
        PolicyDao policyDao = new PolicyDaoImpl(new PolicyRepositoryImpl());
        ClaimDao claimDao = new ClaimDaoImpl(new ClaimRepositoryImpl());
        return new UserController(
                policyDao,
                claimDao,
                new PolicyServiceImpl(),
                new ClaimServiceImpl(),
                new CustomerServiceImpl(),
                new PremiumCalculationServiceImpl(),
                new ReportServiceImpl()
        );
    }

    public PolicyDto createPolicy(String customerName, double coverageAmount, double baseRatePercent) {
        CustomerDto customer = customerService.createCustomer(customerName);
        double premium = premiumCalculator.calculatePremium(coverageAmount, baseRatePercent);
        PolicyDto policy = policyService.createPolicy(customer, coverageAmount, premium);
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
            double payoutAmount = Math.min(claim.getDamageAmount(), claim.getPolicy().getCoverageAmount());
            payoutAmount += claim.getPolicy().getPremium();
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
