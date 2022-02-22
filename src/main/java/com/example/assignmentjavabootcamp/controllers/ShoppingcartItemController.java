package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestCart;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
@Slf4j
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

    @GetMapping()
    public ResponseEntity<?> getAllItemInCart(@RequestParam Long customerId) {
        List<ShoppingcartItem> itemList = shoppingcartItemService.getAllShoppingcartItem(customerId);
        return ResponseEntity.ok(itemList);
    }

    @GetMapping(value = "/getSummary")
    public ResponseEntity<?> getSummary(@RequestParam Long customerId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(shoppingcartItemService.getSummary(customerId).toString());
    }

}
