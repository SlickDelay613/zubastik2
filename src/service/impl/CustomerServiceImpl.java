package service.impl;

import model.CustomerDto;
import exception.ValidationException;
import service.CustomerService;

import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto createCustomer(String name) {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Имя клиента не может быть пустым!");
        }
        String customerId = UUID.randomUUID().toString();
        return new CustomerDto(customerId, name);
    }
}
