package service.impl;

import helper.Numerator;
import model.CustomerDto;
import exception.ValidationException;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto createCustomer(String name) {
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Имя клиента не может быть пустым!");
        }
        String customerId = String.valueOf(Numerator.makeNewNumberForType(CustomerDto.class));
        return new CustomerDto(customerId, name);
    }
}
