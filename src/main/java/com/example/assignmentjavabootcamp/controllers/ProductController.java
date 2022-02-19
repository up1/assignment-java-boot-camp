package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/search")
    private ResponseEntity<?> findProduct(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.findProductByContainsName(keyword));
    }
}
