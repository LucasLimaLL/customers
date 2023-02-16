package com.lucaslima.cms.application.domains.customers;

import lombok.Getter;

@Getter
public class Email {

    private final String value;

    public Email(String value) {
        this.value = value;
    }
}
