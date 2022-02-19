package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

   List<Product> findByNameContains(String name);
}
