package com.viggad.trackingmoney.exception;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String message) {
        super(message);
    }
}
