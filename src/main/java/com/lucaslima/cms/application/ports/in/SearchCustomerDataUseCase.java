package com.lucaslima.cms.application.ports.in;

import com.lucaslima.cms.application.domains.customers.Customer;

public interface SearchCustomerDataUseCase {

    Customer search(String cnpj);
}
