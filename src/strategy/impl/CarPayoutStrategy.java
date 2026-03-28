package strategy.impl;

import model.ClaimDto;
import strategy.PayoutCalculationStrategy;

public class CarPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount(), claim.getPolicy().getCoverageAmount()) + claim.getPolicy().getPremium();
    }
    @Override
    public String getSupportedType() {
        return "АВТО";
    }
}