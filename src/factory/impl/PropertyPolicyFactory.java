package factory.impl;

import factory.PolicyFactory;
import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;
import helper.Numerator;

public class PropertyPolicyFactory implements PolicyFactory {
    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium) {
        String policyNumber = String.valueOf(Numerator.makeNewNumberForType(PolicyDto.class));
        return new PolicyDto(policyNumber, customer, coverageAmount, premium, PolicyType.PROPERTY);
    }

    @Override
    public PolicyType getSupportedType() {
        return PolicyType.PROPERTY;
    }
}