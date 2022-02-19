package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<?> findProductByContainsName(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.findProductByContainsName(keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

}
