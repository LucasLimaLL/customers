package com.lucaslima.cms.application.domains.customers;

import com.lucaslima.cms.application.domains.addresses.Address;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Customer {

    private final String legalName;
    private final String brandName;
    private final CNPJ cnpj;
    private final String stateRegistration;
    private final Address address;
    private final List<Phone> phones;
    private final List<Email> emails;
    private final Boolean active;

    @Builder(toBuilder = true, setterPrefix = "with")
    public Customer(String legalName,
                    String brandName,
                    CNPJ cnpj,
                    String stateRegistration,
                    Address address,
                    List<Phone> phones,
                    List<Email> emails,
                    Boolean active) {
        this.legalName = legalName;
        this.brandName = brandName;
        this.cnpj = cnpj;
        this.stateRegistration = stateRegistration;
        this.address = address;
        this.phones = phones;
        this.emails = emails;
        this.active = active;
    }
}
