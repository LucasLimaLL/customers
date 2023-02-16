package com.lucaslima.cms.application.services;

import com.lucaslima.cms.application.domains.customers.Customer;
import com.lucaslima.cms.application.ports.in.RegisterCustomerUseCase;
import com.lucaslima.cms.application.ports.out.RegisterCustomerPort;
import com.lucaslima.cms.application.services.validators.CustomerValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final CustomerValidator customerValidator;
    private final RegisterCustomerPort registerCustomerPort;

    @Override
    public Customer register(Customer customer) {
        this.customerValidator.isValid(customer);
        return registerCustomerPort.register(customer);
    }
}
