package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestAddCreditCard;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCreditCard")
    public ResponseEntity<?> addCreditCard(@RequestBody @Valid RequestAddCreditCard request) {
        Customer customer = customerService.addCreditCard(request.getCustomerId(), new CreditCard(request.getCreditCardNumber(), request.getCvv(), request.getExp()));
        return ResponseEntity.ok(customer);
    }
}
