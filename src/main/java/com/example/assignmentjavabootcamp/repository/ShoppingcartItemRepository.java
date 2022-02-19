package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingcartItemRepository extends JpaRepository<ShoppingcartItem, Long> {
    Optional<ShoppingcartItem> findByCustomerCustomerIdAndProductProductId(Long customerId, Long productId);
}
