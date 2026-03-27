package service.impl;

import exception.ValidationException;
import service.PremiumCalculationService;

public class PremiumCalculationServiceImpl implements PremiumCalculationService {
    @Override
    public double calculatePremium(double coverageAmount, double baseRatePercent) {
        if (coverageAmount <= 0) {
            throw new ValidationException("Страховая сумма должна быть положительной!");
        }
        if (baseRatePercent <= 0) {
            throw new ValidationException("Страховой тариф должен быть положительным!");
        }
        double rate = baseRatePercent / 100.0;
        return coverageAmount * rate;
    }
}


