package com.example.assignmentjavabootcamp.exceptions;

public class ShoppingcartItemNotFoundException extends RuntimeException {
    public ShoppingcartItemNotFoundException(String message) {
        super(message);
    }
}
