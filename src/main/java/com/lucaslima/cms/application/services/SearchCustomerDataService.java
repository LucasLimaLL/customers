package com.lucaslima.cms.application.services;


import com.lucaslima.cms.application.domains.customers.CNPJ;
import com.lucaslima.cms.application.domains.customers.Customer;
import com.lucaslima.cms.application.exceptions.CustomerDataNotFoundException;
import com.lucaslima.cms.application.ports.in.SearchCustomerDataUseCase;
import com.lucaslima.cms.application.ports.out.SearchCustomerDataPort;

import java.util.Optional;

public class SearchCustomerDataService implements SearchCustomerDataUseCase {

    private final SearchCustomerDataPort searchCustomerDataPort;

    public SearchCustomerDataService(SearchCustomerDataPort searchCustomerDataPort) {
        this.searchCustomerDataPort = searchCustomerDataPort;
    }

    @Override
    public Customer search(String cnpj) {
        Optional<Customer> customer = this.searchCustomerDataPort.search(CNPJ
                .builder()
                .withNumber(cnpj)
                .build());

        if (customer.isEmpty()) {
            throw new CustomerDataNotFoundException(String.format("Cliente com documento '%s' não foi encontrado.", cnpj));
        }

        return customer.get();
    }

}
