package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
