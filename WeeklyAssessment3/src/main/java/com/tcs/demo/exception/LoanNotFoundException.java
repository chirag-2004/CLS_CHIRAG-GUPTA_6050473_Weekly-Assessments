package com.tcs.demo.exception;

@SuppressWarnings("serial")
public class LoanNotFoundException extends RuntimeException {

    public LoanNotFoundException(String message) {
        super(message);
    }
}