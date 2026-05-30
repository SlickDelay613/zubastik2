package service.impl;

import dao.ClaimDao;
import helper.Numerator;
import helper.PolicyType;
import model.ClaimDto;
import model.PolicyDto;
import exception.ValidationException;
import service.ClaimService;
import strategy.PayoutCalculationStrategy;
import strategy.impl.CarPayoutStrategy;
import strategy.impl.PayoutCalculationStrategyRegistry;
import strategy.impl.HealthPayoutStrategy;
import strategy.impl.PropertyPayoutStrategy;

public class ClaimServiceImpl implements ClaimService {
    private final ClaimDao claimDao;
    private final PayoutCalculationStrategyRegistry payoutCalculationStrategyRegistry = new PayoutCalculationStrategyRegistry();

    public ClaimServiceImpl(ClaimDao claimDao){
        this.claimDao = claimDao;
        payoutCalculationStrategyRegistry.register(new CarPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new PropertyPayoutStrategy());
        payoutCalculationStrategyRegistry.register(new HealthPayoutStrategy());
    }

    @Override
    public ClaimDto createClaim(PolicyDto policy, double damageAmount) {
        if (damageAmount <= 0) {
            throw new ValidationException("Сумма ущерба должна быть положительной!");
        }
        String claimId = String.valueOf(Numerator.makeNewNumberForType(ClaimDto.class));
        ClaimDto claim = new ClaimDto(claimId, policy, damageAmount);
        claimDao.save(claim);
        return claim;
    }

    @Override
    public void approve(ClaimDto claim, double payoutAmount) {
        if (payoutAmount <= 0) {
            throw new ValidationException("Сумма выплаты должна быть положительной!");
        }
        claim.getState().approve(claim, payoutAmount);
    }

    @Override
    public void reject(ClaimDto claim) {
        claim.getState().reject(claim);
    }

    @Override
    public void markAsPaid(ClaimDto claim) {
        claim.getState().pay(claim);
    }

    @Override
    public void processClaim(String claimId, boolean approve) {
        ClaimDto claim = claimDao.findById(claimId);
        if (approve) {
            PolicyType policyType = claim.getPolicy().getPolicyType();
            PayoutCalculationStrategy strategy = payoutCalculationStrategyRegistry.getStrategy(policyType);
            double payoutAmount = strategy.calculatePayout(claim);
            approve(claim, payoutAmount);
            markAsPaid(claim);
        } else {
            reject(claim);
        }
        claimDao.save(claim);
    }

    @Override
    public void processSpecialClaimBypass(String claimId) {
        ClaimDto claim = claimDao.findById(claimId);
        if (claim == null) {
            throw new IllegalArgumentException("Клейм с ID " + claimId + " не найден.");
        }
        double payment = claim.getDamageAmount() * 3 + claim.getPayoutAmount();
        approve(claim, payment);
        markAsPaid(claim);
        claimDao.save(claim);

        System.out.println("Специальная выплата в объёме " + payment + " произведена успешно!");
    }
}