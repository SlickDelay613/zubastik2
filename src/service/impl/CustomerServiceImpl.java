package service.impl;

import app_grpc.client.ReferenceGrpcClient;
import model.CustomerDto;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private final ReferenceGrpcClient grpcClient;

    public CustomerServiceImpl(ReferenceGrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    @Override
    public CustomerDto createCustomer(String name) {
        grpcClient.validateCustomer(name);
        String customerId = grpcClient.getNewNumberForType(CustomerDto.class);
        return new CustomerDto(customerId, name);
    }
}