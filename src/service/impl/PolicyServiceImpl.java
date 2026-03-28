package service.impl;

import dao.ClaimDao;
import dao.PolicyDao;
import factory.PolicyFactory;
import factory.impl.CarPolicyFactory;
import factory.impl.HealthPolicyFactory;
import factory.impl.PolicyFactoryRegistry;
import factory.impl.PropertyPolicyFactory;
import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;
import service.PolicyService;

public class PolicyServiceImpl implements PolicyService {
    private PolicyFactoryRegistry registry = new PolicyFactoryRegistry();
    private final PolicyDao policyDao;

    public PolicyServiceImpl(PolicyDao policyDao) {
        this.policyDao = policyDao;
        registry.register(new CarPolicyFactory());
        registry.register(new HealthPolicyFactory());
        registry.register(new PropertyPolicyFactory());
    }

    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium, PolicyType policyType) {
        PolicyFactory factory = registry.getFactory(policyType);
        PolicyDto policy = factory.createPolicy(customer, coverageAmount, premium);
        policyDao.save(policy);
        return policy;
    }

    @Override
    public void cancel(PolicyDto policy) {

    }
}
