package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestAddToCart;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class ShoppingcartItemController {

    private final ShoppingcartItemService shoppingcartItemService;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addProduct(@RequestBody @Valid RequestAddToCart request) {
        ShoppingcartItem item = shoppingcartItemService.addItem(request.getCustomerId(), request.getProductId(), request.getAmount());
        return ResponseEntity.ok(item);
    }
}
