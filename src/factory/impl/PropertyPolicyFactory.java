package factory.impl;

import app_grpc.client.ReferenceGrpcClient;
import factory.PolicyFactory;
import helper.PolicyType;
import model.CustomerDto;
import model.PolicyDto;

import static helper.PolicyType.PROPERTY;

public class PropertyPolicyFactory implements PolicyFactory {
    private final ReferenceGrpcClient grpcClient;

    public PropertyPolicyFactory(ReferenceGrpcClient grpcClient){
        this.grpcClient = grpcClient;
    }

    @Override
    public PolicyDto createPolicy(CustomerDto customer, double coverageAmount, double premium) {
        String policyNumber = grpcClient.getNewNumberForType(PolicyDto.class);
        return new PolicyDto(policyNumber, customer, coverageAmount, premium, PROPERTY);
    }

    @Override
    public PolicyType getSupportedType() {
        return PROPERTY;
    }
}