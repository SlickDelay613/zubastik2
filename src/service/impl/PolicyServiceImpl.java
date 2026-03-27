package service.impl;

import helper.Numerator;
import model.CustomerDto;
import model.PolicyDto;
import exception.ValidationException;
import service.PolicyService;

import java.util.Objects;

public class PolicyServiceImpl implements PolicyService {
    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium) {
        if (coverageAmount <= 0) {
            throw new ValidationException("Страховая сумма должна быть положительной!");
        }
        if (premium <= 0) {
            throw new ValidationException("Страховая премия должна быть положительной!");
        }
        if (Objects.equals(customer.getName(), "")){
            throw new ValidationException("ФИО клиента не может быть пустым!");
        }
        String policyNumber = String.valueOf(Numerator.makeNewNumberForType(CustomerDto.class));
        return new PolicyDto(policyNumber, customer, coverageAmount, premium);
    }

    @Override
    public void cancel(PolicyDto policy) {
        policy.setActive(false);
    }
}
