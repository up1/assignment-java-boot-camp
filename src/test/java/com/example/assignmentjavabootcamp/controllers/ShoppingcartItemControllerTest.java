package com.example.assignmentjavabootcamp.controllers;

import com.example.assignmentjavabootcamp.dto.RequestCart;
import com.example.assignmentjavabootcamp.exceptions.ShoppingcartItemNotFoundException;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.repository.ShoppingcartItemRepository;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ShoppingcartItemControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    ShoppingcartItemService shoppingcartItemService;

    @Autowired
    ShoppingcartItemRepository shoppingcartItemRepository;

    @BeforeEach
    public void setup() {
        shoppingcartItemService.addItem(1L, 1L, 3);
    }

    @AfterEach
    public void removeOldDate() {
        shoppingcartItemRepository.deleteAll();
    }

    @Test
    public void whenAddItemToCart_ShouldReturnItem() {
        RequestCart request = new RequestCart(1L, 1L, 1);
        String response = testRestTemplate.postForObject("/carts/addToCart", request, String.class);
        assertEquals(request.getAmount() + 3, new JSONObject(response).getInt("amount"));
    }

    @Test
    public void whenAddItemToCartMoreThanAmount_ShouldReturn400() {
        RequestCart request = new RequestCart(1L, 1L, 200);
        String response = testRestTemplate.postForObject("/carts/addToCart", request, String.class);
        assertEquals(400, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenRemoveItemFromCartMoreThanAmount_ShouldReturn400() {
        RequestCart request = new RequestCart(1L, 1L, 400);
        String response = testRestTemplate.postForObject("/carts/removeFromCart", request, String.class);
        assertEquals(400, new JSONObject(response).getInt("status"));
    }

    @Test
    public void whenRemove1ItemFromCart_ShouldReduceItem() {
        RequestCart request = new RequestCart(1L, 1L, 1);
        String response = testRestTemplate.postForObject("/carts/removeFromCart", request, String.class);
        assertEquals(2, new JSONObject(response).getInt("amount"));
    }

    @Test
    public void whenRemoveAllItemFromCart_ShouldReturnNull() {
        RequestCart request = new RequestCart(1L, 1L, 3);
        String response = testRestTemplate.postForObject("/carts/removeFromCart", request, String.class);
        assertNull(response);
    }

    @Test
    public void whenGetCartSummary_ShouldReturnSummary() {
        String response = testRestTemplate.getForObject("/carts/getSummary?customerId=1", String.class);
        assertTrue(new JSONObject(response).has("total"));
    }

    @Test
    public void whenGetEmptyCartSummary_ShouldReturnNull() {
        shoppingcartItemService.removeItem(1L, 1L, 3);
        String response = testRestTemplate.getForObject("/carts/getSummary?customerId=1", String.class);
        System.out.println(response);
        assertTrue(new JSONObject(response).isEmpty());
    }
}