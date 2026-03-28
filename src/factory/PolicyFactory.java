package factory;

import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;

public interface PolicyFactory {
    PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium);
    PolicyType getSupportedType();
}