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

        Product resultProduct = productService.findProductById(1L);
        assertNotNull(resultProduct);
    }

    @Test
    public void whenGetUnsavedProductId_ShouldThrowException() {
        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.findProductById(1L));
    }
}