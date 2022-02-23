package com.example.week02.relations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("ทำการสร้าง customer และ address")
    public void case01() {
        // Create data
        Customer customer = new Customer(1);
        Address address01 = new Address(1, customer);
        Address address02 = new Address(2, customer);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address01);
        addresses.add(address02);
        customer.setAddresses(addresses);

        entityManager.persist(customer);
//        entityManager.persist(address01);
//        entityManager.persist(address02);

        // Get data
        Customer foundCustomer =  repository.getById(1);
        // Assert
        assertEquals(2, foundCustomer.getAddresses().size());
        assertEquals(1,
                foundCustomer.getAddresses().get(0).getCustomer().getId());
        assertEquals(1,
                foundCustomer.getAddresses().get(1).getCustomer().getId());
        assertEquals(1, foundCustomer.getAddresses().get(0).getId());
        assertEquals(2, foundCustomer.getAddresses().get(1).getId());
    }

}