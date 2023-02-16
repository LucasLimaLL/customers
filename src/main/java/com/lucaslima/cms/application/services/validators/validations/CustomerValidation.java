package com.lucaslima.cms.application.services.validators.validations;

import com.lucaslima.cms.application.domains.customers.Customer;
import com.lucaslima.cms.application.exceptions.InvalidDataException;

public abstract class CustomerValidation {

    public boolean isValid(Customer customer) {

        if (ruleWasBroken(customer)) {
            throw new InvalidDataException(message(customer));
        }

        return true;
    }

    protected abstract String message(Customer customer);

    protected abstract boolean ruleWasBroken(Customer customer);
}
