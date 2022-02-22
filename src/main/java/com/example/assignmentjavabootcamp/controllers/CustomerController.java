package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestAddCreditCard;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.services.CustomerService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
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
        customerService.addCreditCard(request.getCustomerId(), new CreditCard(request.getCreditCardNumber(), request.getCvv(), request.getExp()));
        return ResponseEntity.ok(new JSONObject()
                .put("message", "added credit card")
                .put("status", 200)
        );
    }

    @PostMapping("/addShippingAddress")
    public ResponseEntity<?> addShippingAddress(@RequestBody @Valid RequestShippingAddress address) {
        return ResponseEntity.ok().body(customerService.addShippingAddress(address));
    }
}
