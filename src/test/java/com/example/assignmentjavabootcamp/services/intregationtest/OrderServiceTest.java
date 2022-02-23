package com.example.assignmentjavabootcamp.services.intregationtest;

import com.example.assignmentjavabootcamp.exceptions.OrderNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.services.CustomerService;
import com.example.assignmentjavabootcamp.services.OrderService;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ShoppingcartItemService shoppingcartItemService;

    Customer customer;

    @BeforeEach
    public void setup() {
        customer = customerService.getCustomer(1L);
        customerService.addCreditCard(customer.getCustomerId(), new CreditCard("1234567890123458", "222", "09/26"));
        shoppingcartItemService.addItem(customer.getCustomerId(), 1L, 2);
        shoppingcartItemService.addItem(customer.getCustomerId(), 2L, 2);
    }

    @Test
    public void whenBuildOrder_ShouldGetOrder() {
        orderService.buildOrder(customer, shoppingcartItemService.getAllShoppingcartItem(customer.getCustomerId()));
        JSONObject jsonObject = orderService.getLatestOrder(customer.getCustomerId());

        assertNotNull(jsonObject);
    }

    @Test
    public void whenGetUnBuildOrder_ShouldThrowOrderNotFoundException() {
        Assertions.assertThrows(OrderNotFoundException.class, () -> orderService.getLatestOrder(3L));
    }

}