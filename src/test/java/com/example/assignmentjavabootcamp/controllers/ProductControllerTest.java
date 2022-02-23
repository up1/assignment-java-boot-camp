package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void whenGetUnsavedProductId_ShouldReturn404() {
        String responseString = testRestTemplate.getForObject("/products/9", String.class);
        assertEquals(404, new JSONObject(responseString).getInt("status"));
    }

    @Test
    public void whenGetSavedProductId_ShouldReturnProduct() throws JsonProcessingException {
        String responseString = testRestTemplate.getForObject("/products/1", String.class);
        Product product = mapper.readValue(responseString, Product.class);
        assertNotNull(product);
    }

}