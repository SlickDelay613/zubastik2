package service;

import model.CustomerDto;
import model.PolicyDto;

public interface PolicyService {
    PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium, String policyType);
    void cancel(PolicyDto policy);
}
