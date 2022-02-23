package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestAddCreditCard;
import com.example.assignmentjavabootcamp.dto.RequestShippingAddress;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void whenAddCreditCard_ShouldReturn200() {
        RequestAddCreditCard request = new RequestAddCreditCard(1L, "1234567890123456", "222", "11/24");
        String response = testRestTemplate.postForObject("/customers/addCreditCard", request, String.class);
        assertEquals(200, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenSendNullCustomerId_ShouldReturn400() {
        RequestAddCreditCard request = new RequestAddCreditCard(null, "1234567829012356", "222", "11/24");
        String response = testRestTemplate.postForObject("/customers/addCreditCard", request, String.class);
        assertEquals(400, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenSendNotAccurateNumberCreditCard_ShouldReturn400() {
        RequestAddCreditCard request = new RequestAddCreditCard(null, "1234567829012356", "222", "11/24");
        String response = testRestTemplate.postForObject("/customers/addCreditCard", request, String.class);
        assertEquals(400, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenSendNotAccurateNumberCVC_ShouldReturn400() {
        RequestAddCreditCard request = new RequestAddCreditCard(null, "1234567829012356", "22", "11/24");
        String response = testRestTemplate.postForObject("/customers/addCreditCard", request, String.class);
        assertEquals(400, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenAddShippingAddress_ShouldReturnAddress() {
        RequestShippingAddress address = new RequestShippingAddress(1L, "34 Moo8", "73110", "Bangkok", "0911111111");
        String response = testRestTemplate.postForObject("/customers/addShippingAddress", address, String.class);
        assertEquals(1L, new JSONObject(response).getLong("customerId"));
    }

}