package strategy.impl;

import helper.PolicyType;
import strategy.PayoutCalculationStrategy;

import java.util.HashMap;
import java.util.Map;

public class PayoutCalculationStrategyRegistry {
    private final Map<PolicyType, PayoutCalculationStrategy> strategies = new HashMap<>();

    public void register(PayoutCalculationStrategy strategy) {
        strategies.put(strategy.getSupportedType(), strategy);
    }

    public PayoutCalculationStrategy getStrategy(PolicyType type) {
        PayoutCalculationStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Неизвестный тип полиса: " + type);
        }
        return strategy;
    }
}
