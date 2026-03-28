package strategy.impl;

import model.ClaimDto;
import strategy.PayoutCalculationStrategy;

public class HealthPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount(), claim.getPolicy().getCoverageAmount());
    }
    @Override
    public String getSupportedType() {
        return "ЗДОР";
    }
}