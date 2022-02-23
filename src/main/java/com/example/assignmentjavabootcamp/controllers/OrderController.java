package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.services.OrderService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestOrder(@RequestParam Long customerId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.getLatestOrder(customerId).toString());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderService.getOrderById(orderId).toString());
    }
}
