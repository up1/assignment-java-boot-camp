package com.example.assignmentjavabootcamp.services.unittest;

import com.example.assignmentjavabootcamp.exceptions.ProductNotFoundException;
import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.repository.ProductRepository;
import com.example.assignmentjavabootcamp.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Autowired
    ObjectMapper mapper;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void whenGetSavedProductId_ShouldReturnProduct() {
        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(new Product()));

        Product resultProduct = productService.getProductById(1L);
        assertNotNull(resultProduct);
    }

    @Test
    public void whenGetUnsavedProductId_ShouldThrowException() {
        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.getProductById(1L));
    }

    @Test
    public void whenGetContainsProductName_ShouldReturnListOfProduct() {
        List<Product> mockProductList = Arrays.asList(new Product("Adidas Runner", "9", 2_900d, "UK", "Black", 15),
                new Product("Adidas Running", "9", 2_900d, "UK", "Black", 15),
                new Product("Adidas Walking", "9", 2_900d, "UK", "Black", 15)
        );

        Mockito.when(productRepository.findByNameContains(Mockito.any())).thenReturn(mockProductList);

        List<Product> productList = productService.getProductByContainsName("Adidas");
        assertFalse(productList.isEmpty());
    }

    @Test
    public void whenGetNotContainsProductName_ShouldReturnEmptyList() {
        Mockito.when(productRepository.findByNameContains(Mockito.any())).thenReturn(new ArrayList<>());

        List<Product> productList = productService.getProductByContainsName("Adidas");
        assertFalse(productList.isEmpty());
    }

}