package com.lucaslima.cms.application.domains.addresses;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Address {

    private final String zipCode;
    private final String state;
    private final String city;
    private final String neighborhood;
    private final String address;
    private final String number;
    private final String complement;

    @Builder(toBuilder = true, setterPrefix = "with")
    public Address(String zipCode, String state, String city, String neighborhood, String address, String number, String complement) {
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.address = address;
        this.number = number;
        this.complement = complement;
    }
}
