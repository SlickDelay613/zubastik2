package factory.impl;

import app_grpc.client.ReferenceGrpcClient;
import factory.PolicyFactory;
import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;

import static helper.PolicyType.HEALTH;

public class HealthPolicyFactory implements PolicyFactory {
    private final ReferenceGrpcClient grpcClient;

    public HealthPolicyFactory(ReferenceGrpcClient grpcClient){
        this.grpcClient = grpcClient;
    }

    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium) {
        String policyNumber = grpcClient.getNewNumberForType(PolicyDto.class);
        return new PolicyDto(policyNumber, customer, coverageAmount, premium, HEALTH);
    }

    @Override
    public PolicyType getSupportedType() {
        return HEALTH;
    }
}