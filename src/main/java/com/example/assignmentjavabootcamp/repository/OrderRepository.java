package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findFirstByOrderOwnerOrderByBuyAt(Long customerId);
}
