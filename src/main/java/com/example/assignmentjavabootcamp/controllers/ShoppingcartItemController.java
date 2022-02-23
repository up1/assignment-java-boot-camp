package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestCart;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
@Slf4j
public class ShoppingcartItemController {

    private final ShoppingcartItemService shoppingcartItemService;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addProductToCart(@RequestBody @Valid RequestCart request) {
        ShoppingcartItem item = shoppingcartItemService.addItem(request.getCustomerId(), request.getProductId(), request.getAmount());
        return ResponseEntity.ok(item);
    }

    @PostMapping("/removeFromCart")
    public ResponseEntity<?> removeProductFromCart(@RequestBody @Valid RequestCart request) {
        ShoppingcartItem item = shoppingcartItemService.removeItem(request.getCustomerId(), request.getProductId(), request.getAmount());
        return ResponseEntity.ok(item);
    }

    @GetMapping()
    public ResponseEntity<?> getAllItemInCart(@RequestParam Long customerId) {
        List<ShoppingcartItem> itemList = shoppingcartItemService.getAllShoppingcartItem(customerId);
        JSONObject jsonObject = new JSONObject(itemList);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject.toString());
    }

    @GetMapping(value = "/getSummary")
    public ResponseEntity<?> getSummary(@RequestParam Long customerId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(shoppingcartItemService.getSummary(customerId).toString());
    }

    @PostMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkout(@RequestBody String request) {
        Long customerId = new JSONObject(request).getLong("customerId");
        shoppingcartItemService.checkout(customerId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new JSONObject()
                        .put("message", "checkout complete")
                        .put("status", 200).toString());
    }

}
