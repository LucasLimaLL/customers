package com.lucaslima.cms.application.domains.customers;

import lombok.Getter;

@Getter
public class Phone {

    private final Integer ddd;
    private final Long number;

    public Phone(String value) {
        this.ddd = Integer.valueOf(value.substring(0, 2));
        this.number = Long.valueOf(value.substring(2));
    }
}
