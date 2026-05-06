package service.impl;

import app_grpc.client.ReferenceGrpcClient;
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
    private final PolicyFactoryRegistry registry = new PolicyFactoryRegistry();
    private final PolicyDao policyDao;
    private final ReferenceGrpcClient grpcClient;

    public PolicyServiceImpl(PolicyDao policyDao, ReferenceGrpcClient grpcClient) {
        this.policyDao = policyDao;
        this.grpcClient = grpcClient;
        registry.register(new CarPolicyFactory(grpcClient));
        registry.register(new HealthPolicyFactory(grpcClient));
        registry.register(new PropertyPolicyFactory(grpcClient));
    }

    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium, PolicyType policyType) {
        PolicyFactory factory = registry.getFactory(policyType);
        PolicyDto policy = factory.createPolicy(customer, coverageAmount, premium);
        policyDao.save(policy);
        return policy;
    }
}
