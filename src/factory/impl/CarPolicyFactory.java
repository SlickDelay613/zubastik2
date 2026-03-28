package factory.impl;

import factory.PolicyFactory;
import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;
import helper.Numerator;

import static helper.PolicyType.AUTO;

public class CarPolicyFactory implements PolicyFactory {
    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium) {
        String policyNumber = String.valueOf(Numerator.makeNewNumberForType(PolicyDto.class));
        return new PolicyDto(policyNumber, customer, coverageAmount, premium, AUTO);
    }

    @Override
    public PolicyType getSupportedType() {
        return AUTO;
    }
}