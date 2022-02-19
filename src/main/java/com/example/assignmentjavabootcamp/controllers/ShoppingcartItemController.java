package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestCart;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class ShoppingcartItemController {

    private final ShoppingcartItemService shoppingcartItemService;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addProductToCart(@RequestBody @Valid RequestCart request) {
        ShoppingcartItem item = shoppingcartItemService.addItem(request.getCustomerId(), request.getProductId(), request.getAmount());
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/removeFromCart")
    public ResponseEntity<?> removeProductFromCart(@RequestBody @Valid RequestCart request) {
        ShoppingcartItem item = shoppingcartItemService.removeItem(request.getCustomerId(), request.getProductId(), request.getAmount());
        return ResponseEntity.ok(item);
    }
}
