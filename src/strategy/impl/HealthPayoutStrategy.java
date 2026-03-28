package strategy.impl;

import helper.PolicyType;
import model.ClaimDto;
import strategy.PayoutCalculationStrategy;

public class HealthPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount(), claim.getPolicy().getCoverageAmount());
    }
    @Override
    public PolicyType getSupportedType() {
        return PolicyType.HEALTH;
    }
}