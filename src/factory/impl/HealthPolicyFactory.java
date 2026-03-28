package factory.impl;

import factory.PolicyFactory;
import model.CustomerDto;
import model.PolicyDto;
import helper.Numerator;

public class HealthPolicyFactory implements PolicyFactory {
    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium) {
        String policyNumber = String.valueOf(Numerator.makeNewNumberForType(PolicyDto.class));
        return new PolicyDto(policyNumber, customer, coverageAmount, premium, "ЗДОР");
    }

    @Override
    public String getSupportedType() {
        return "ЗДОР";
    }
}