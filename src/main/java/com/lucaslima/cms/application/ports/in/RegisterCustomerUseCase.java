package com.lucaslima.cms.application.ports.in;

import com.lucaslima.cms.application.domains.customers.Customer;

public interface RegisterCustomerUseCase {

    Customer register(Customer customer);
}
