package strategy;

import model.ClaimDto;

public class PropertyPayoutStrategy implements PayoutCalculationStrategy {
    @Override
    public double calculatePayout(ClaimDto claim) {
        return Math.min(claim.getDamageAmount() * 0.8, claim.getPolicy().getCoverageAmount());
    }
}