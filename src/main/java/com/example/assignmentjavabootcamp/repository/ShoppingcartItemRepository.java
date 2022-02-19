package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingcartItemRepository extends JpaRepository<ShoppingcartItem,Long> {
}
