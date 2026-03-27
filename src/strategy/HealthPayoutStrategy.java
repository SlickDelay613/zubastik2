package strategy;

import model.ClaimDto;

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