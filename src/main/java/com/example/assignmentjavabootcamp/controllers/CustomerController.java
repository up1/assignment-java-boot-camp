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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/addCreditCard")
    public ResponseEntity<?> addCreditCard(@RequestBody @Valid RequestAddCreditCard request) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("MM/yy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 31)
                .toFormatter();

        LocalDate dateExpired = LocalDate.parse(request.getExp(), formatter);

        Customer customer = customerService.addCreditCard(request.getCustomerId(), new CreditCard(request.getCreditCardNumber(), request.getCvv(), dateExpired));
        return ResponseEntity.ok(customer);
    }
}
