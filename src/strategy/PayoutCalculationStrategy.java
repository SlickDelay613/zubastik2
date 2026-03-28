package strategy;

import helper.PolicyType;
import model.ClaimDto;

public interface PayoutCalculationStrategy {
    double calculatePayout(ClaimDto claim);
    PolicyType getSupportedType();
}