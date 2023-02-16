package com.lucaslima.cms.application.services.validators.validations;

import com.lucaslima.cms.application.domains.customers.CNPJ;
import com.lucaslima.cms.application.domains.customers.Customer;
import com.lucaslima.cms.application.exceptions.InvalidDataException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CnpjIsValidTest {

    private final CnpjIsValid validation = new CnpjIsValid(List.of("11222333000181"));

    @ParameterizedTest
    @ValueSource(strings = {"", "0123456789", "01234s67890", "11222333000180", "11222333000181", "11.222.333/0001-81"})
    void testCnpjisInvalid(String number) {
        Exception exception = assertThrows(Exception.class, () -> validation.isValid(Customer
                .builder()
                .withCnpj(CNPJ.builder().withNumber(number).build())
                .build()));

        assertThat(exception).isInstanceOf(InvalidDataException.class);
        assertThat(exception.getLocalizedMessage()).isEqualTo("CNPJ inválido");
    }

    @ParameterizedTest
    @ValueSource(strings = {"21089068000169", "21.089.068/0001-69"})
    void testCnpjisValid(String number) {
        assertThat(validation.isValid(Customer
                .builder()
                .withCnpj(CNPJ.builder().withNumber(number).build())
                .build())).isEqualTo(true);
    }
}