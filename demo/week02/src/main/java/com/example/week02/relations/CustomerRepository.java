package com.example.week02.relations;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @EntityGraph(value = "customer-entity-graph-with-address-customer")
    Customer findByName(String name);

}
