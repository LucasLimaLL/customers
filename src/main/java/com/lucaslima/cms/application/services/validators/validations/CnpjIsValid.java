package com.lucaslima.cms.application.services.validators.validations;

import com.lucaslima.cms.application.domains.customers.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CnpjIsValid extends CustomerValidation {

    public static final String ONLY_NUMBERS_REGEX = "[^0-9]";
    private static final String EQUAL_NUMBERS_REGEX = "(\\d)\\1{13}";
    private final List<String> blacklist;

    @Override
    protected String message(Customer customer) {
        return "CNPJ inválido";
    }

    @Override
    protected boolean ruleWasBroken(Customer customer) {
        return !validateCNPJ(customer.getCnpj().getNumber());
    }

    private boolean validateCNPJ(String cnpj) {

        cnpj = cnpj.replaceAll(ONLY_NUMBERS_REGEX, "");

        // Verifica se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14
                || cnpj.matches(EQUAL_NUMBERS_REGEX)
                || blacklist.contains(cnpj)) {
            return false;
        }


        try {
            int dig13;
            int dig14;
            int sum = 0;
            int peso = 2;
            int num;

            for (int i = 11; i >= 0; i--) {
                num = Integer.parseInt(cnpj.substring(i, i + 1));
                sum = sum + (num * peso);
                peso = (peso == 9) ? 2 : peso + 1;
            }

            dig13 = (sum % 11 <= 1)
                    ? 0
                    : (11 - sum % 11);

            sum = 0;
            peso = 2;
            for (int i = 12; i >= 0; i--) {
                num = Integer.parseInt(cnpj.substring(i, i + 1));
                sum = sum + (num * peso);
                peso = (peso == 9) ? 2 : peso + 1;

            }

            dig14 = (sum % 11 <= 1)
                    ? 0
                    : (11 - sum % 11);


            return (Integer.valueOf(dig13).equals(Integer.valueOf(cnpj.substring(12, 13)))) &&
                    (Integer.valueOf(dig14).equals(Integer.valueOf(cnpj.substring(13, 14))));
        } catch (Exception e) {
            return false;
        }
    }

}
