package com.example.assignmentjavabootcamp.services.unittest;

import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.models.Product;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.repository.ShoppingcartItemRepository;
import com.example.assignmentjavabootcamp.services.CustomerService;
import com.example.assignmentjavabootcamp.services.OrderService;
import com.example.assignmentjavabootcamp.services.ProductService;
import com.example.assignmentjavabootcamp.services.ShoppingcartItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShoppingcartItemServiceTest {

    @Mock
    ShoppingcartItemRepository shoppingcartItemRepository;

    @Mock
    CustomerService customerService;

    @Mock
    ProductService productService;

    @Mock
    OrderService orderService;

    @InjectMocks
    ShoppingcartItemService shoppingcartItemService;

    Customer customer;

    ShoppingcartItem item;

    Product product;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setCustomerId(1L);
        customer.setProvince("BKK");
        customer.setPhoneNumber("0911111111");
        customer.setAddress("123 Tower");
        customer.setFirstname("Jelly");
        customer.setFirstname("Hank");
        customer.setZipCode("12345");
        Mockito.when(customerService.getCustomer(Mockito.any())).thenReturn(customer);

        product = new Product("Adidas Runner", "9", 2_900d, "UK", "Black", 15);
        product.setProductId(1L);
        Mockito.when(productService.getProductById(Mockito.any())).thenReturn(product);
    }

    @Test
    public void whenAdd2ItemToCart_ShouldHave2AmountItem() {
        int amount = 2;
        Mockito.when(shoppingcartItemService.save(Mockito.any())).thenReturn(new ShoppingcartItem(product, amount, customer));
        ShoppingcartItem item = shoppingcartItemService.addItem(1L, 1L, amount);

        assertEquals(2, item.getAmount());
    }

    @Test
    public void whenAdd1Item2TimesToCart_ShouldHave2AmountItem() {
        int amount = 1;

        ShoppingcartItem shoppingcartItem = new ShoppingcartItem(product, amount, customer);

        Mockito.when(shoppingcartItemService.save(Mockito.any())).thenReturn(shoppingcartItem);

        ShoppingcartItem item;
        shoppingcartItemService.addItem(1L, 1L, amount);

        Mockito.when(shoppingcartItemRepository.findByCustomerCustomerIdAndProductProductId(Mockito.any(), Mockito.any())).thenReturn(Optional.of(shoppingcartItem));
        item = shoppingcartItemService.addItem(1L, 1L, amount);

        assertEquals(2, item.getAmount());
    }

    @Test
    public void whenRemove1Item_ShouldReduceAmountOfItem() {
        ShoppingcartItem shoppingcartItem = new ShoppingcartItem(product, 2, customer);
        Mockito.when(shoppingcartItemService.save(Mockito.any())).thenReturn(shoppingcartItem);

        Mockito.when(shoppingcartItemRepository.findByCustomerCustomerIdAndProductProductId(Mockito.any(), Mockito.any())).thenReturn(Optional.of(shoppingcartItem));
        ShoppingcartItem item = shoppingcartItemService.removeItem(1L, 1L, 1);

        assertEquals(1, item.getAmount());
    }

    @Test
    public void whenRemove1Item2Times_ShouldReduceAmountOfItem() {
        int amount = 3;
        ShoppingcartItem shoppingcartItem = new ShoppingcartItem(product, amount, customer);
        Mockito.when(shoppingcartItemService.save(Mockito.any())).thenReturn(shoppingcartItem);
        Mockito.when(shoppingcartItemRepository.findByCustomerCustomerIdAndProductProductId(Mockito.any(), Mockito.any())).thenReturn(Optional.of(shoppingcartItem));
        shoppingcartItemService.removeItem(1L, 1L, 1);
        ShoppingcartItem addItem = shoppingcartItemService.removeItem(1L, 1L, 1);

        assertEquals(1, addItem.getAmount());
    }
}