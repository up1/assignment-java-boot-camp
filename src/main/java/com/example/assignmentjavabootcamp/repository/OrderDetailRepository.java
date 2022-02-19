package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
