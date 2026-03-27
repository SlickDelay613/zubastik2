package strategy;

import model.ClaimDto;

public interface PayoutCalculationStrategy {
    double calculatePayout(ClaimDto claim);
    String getSupportedType();
}