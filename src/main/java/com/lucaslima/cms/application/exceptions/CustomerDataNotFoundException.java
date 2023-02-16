package com.lucaslima.cms.application.exceptions;

public class CustomerDataNotFoundException extends RuntimeException {
    public CustomerDataNotFoundException(String message) {
        super(message);
    }
}
