package strategy.impl;

import helper.PolicyType;
import model.ClaimDto;
import strategy.PayoutCalculationStrategy;

public class CarPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount(), claim.getPolicy().getCoverageAmount()) + claim.getPolicy().getPremium();
    }
    @Override
    public PolicyType getSupportedType() {
        return PolicyType.AUTO;
    }
}