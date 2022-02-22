package com.example.assignmentjavabootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class,
            CustomerNotFoundException.class,
            CreditCardNotFoundException.class,
            ShoppingcartItemNotFoundException.class,
            OrderNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundException(RuntimeException ex) {
        ex.printStackTrace();
        return new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler({
            InvalidInputToShoppingcartException.class,
            ExpireCreditCardException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleInvalidInputException(RuntimeException ex) {
        ex.printStackTrace();
        return new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({
            InvalidCheckoutException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternalException(RuntimeException ex) {
        ex.printStackTrace();
        return new ExceptionResponse(ex.getMessage(), LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value());

    }
}
