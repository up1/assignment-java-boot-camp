package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.services.CustomerService;
import com.example.assignmentjavabootcamp.services.ProductService;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    CustomerService customerService;

    Customer customer;

    @Autowired
    ProductService productService;

    @Autowired
    ShoppingcartItemService shoppingcartItemService;


    @Test
    public void whenGetLatestOrder_ShouldReturnOrder() {
        customer = customerService.getCustomer(1L);
        customerService.addCreditCard(customer.getCustomerId(), new CreditCard("1234567890123458", "222", "09/26"));
        shoppingcartItemService.addItem(customer.getCustomerId(), 1L, 1);
        shoppingcartItemService.addItem(customer.getCustomerId(), 2L, 1);
        shoppingcartItemService.checkout(customer.getCustomerId());

        String response = testRestTemplate.getForObject("/orders/latest?customerId=" + customer.getCustomerId(), String.class);
        assertEquals(customer.getCustomerId(), new JSONObject(response).getInt("customerId"));
    }

    @Test
    public void whenGetLatestOrderFromEmptyCustomer_ShouldReturn404() {
        String response = testRestTemplate.getForObject("/orders/latest?customerId=" + 2, String.class);
        assertEquals(404, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenGetSavedOrderId_ShouldReturnOrder() {
        customer = customerService.getCustomer(1L);
        customerService.addCreditCard(customer.getCustomerId(), new CreditCard("1234567890123458", "222", "09/26"));
        shoppingcartItemService.addItem(customer.getCustomerId(), 1L, 1);
        shoppingcartItemService.addItem(customer.getCustomerId(), 2L, 1);
        shoppingcartItemService.checkout(customer.getCustomerId());

        String response = testRestTemplate.getForObject("/orders/1" , String.class);
        assertEquals(customer.getCustomerId(), new JSONObject(response).getInt("customerId"));
    }

    @Test
    public void whenGetUnsavedOrderId_ShouldReturn404() {
        String response = testRestTemplate.getForObject("/orders/1" , String.class);
        assertEquals(404, new JSONObject(response).getInt("status"));
    }
}
