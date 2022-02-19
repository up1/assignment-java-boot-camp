package com.example.assignmentjavabootcamp.repository;

import com.example.assignmentjavabootcamp.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
