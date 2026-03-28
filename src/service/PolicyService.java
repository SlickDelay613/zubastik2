package service;

import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;

public interface PolicyService {
    PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium, PolicyType policyType);
    void cancel(PolicyDto policy);
}
