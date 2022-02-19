package com.example.assignmentjavabootcamp.services.intregationtest;

import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

    @Autowired
    ProductService productService;


    @Test
    public void whenFindContainKeyword_ShouldReturnNotEmptyProductList() {
        List<Product> productList = productService.getProductByContainsName("Adidas");
        assertFalse(productList.isEmpty());
    }

    @Test
    public void  whenFindNotContainKeyword_ShouldReturnEmptyProductList() {
        List<Product> productList = productService.getProductByContainsName("nike");
        assertTrue(productList.isEmpty());
    }

    @Test
    public void whenFindEmptyStringKeyword_ShouldReturnAllProductList() {
        List<Product> productList = productService.getProductByContainsName("");
        assertEquals(5, productList.size());
    }
}
