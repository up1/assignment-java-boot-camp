package com.example.assignmentjavabootcamp.services.intregationtest;

import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.repository.ProductRepository;
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
        List<Product> productList = productService.findProductByContainsName("Adidas");
        assertFalse(productList.isEmpty());
    }

    @Test
    public void  whenFindNotContainKeyword_ShouldReturnEmptyProductList() {
        List<Product> productList = productService.findProductByContainsName("nike");
        assertTrue(productList.isEmpty());
    }

    @Test
    public void whenFindEmptyStringKeyword_ShouldReturnAllProductList() {
        List<Product> productList = productService.findProductByContainsName("");
        assertEquals(5, productList.size());
    }
}
