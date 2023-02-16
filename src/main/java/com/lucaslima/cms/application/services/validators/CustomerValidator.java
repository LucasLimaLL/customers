package com.lucaslima.cms.application.services.validators;

import com.lucaslima.cms.application.domains.customers.Customer;
import com.lucaslima.cms.application.services.validators.validations.CustomerValidation;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerValidator {

    private final List<CustomerValidation> validationList;

    public boolean isValid(Customer customer) {

        return this.validationList
                .stream()
                .allMatch(validation -> validation.isValid(customer));
    }
}
