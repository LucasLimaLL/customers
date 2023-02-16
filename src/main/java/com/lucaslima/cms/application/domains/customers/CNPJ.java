package com.lucaslima.cms.application.domains.customers;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CNPJ {

    private final String number;

    @Builder(toBuilder = true, setterPrefix = "with")
    public CNPJ(String number) {
        this.number = number;
    }
}
