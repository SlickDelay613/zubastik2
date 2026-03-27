package strategy;

import model.ClaimDto;

public class CarPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount(), claim.getPolicy().getCoverageAmount()) + claim.getPolicy().getPremium();
    }
}