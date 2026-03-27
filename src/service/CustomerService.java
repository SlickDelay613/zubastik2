package service;

import model.CustomerDto;

public interface CustomerService {
    CustomerDto createCustomer(String name);
}
