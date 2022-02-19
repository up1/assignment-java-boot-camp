package com.example.assignmentjavabootcamp.exceptions;

public class CreditCardNotFoundException extends RuntimeException {
    public CreditCardNotFoundException(String s) {
        super(s);
    }
}
