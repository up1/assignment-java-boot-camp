package com.example.assignmentjavabootcamp.exceptions;

public class InvalidCheckoutException extends RuntimeException {
    public InvalidCheckoutException(String s) {
        super(s);
    }
}
