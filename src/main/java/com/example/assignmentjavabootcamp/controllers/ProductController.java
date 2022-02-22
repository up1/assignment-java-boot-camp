package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<?> findProductByContainsName(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.getProductByContainsName(keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

}
