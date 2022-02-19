package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
