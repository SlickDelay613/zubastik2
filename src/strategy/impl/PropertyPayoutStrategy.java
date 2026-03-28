package strategy.impl;

import model.ClaimDto;
import strategy.PayoutCalculationStrategy;

public class PropertyPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount() * 0.8, claim.getPolicy().getCoverageAmount());
    }

    @Override
    public String getSupportedType() {
        return "НЕДВИЖ";
    }
}