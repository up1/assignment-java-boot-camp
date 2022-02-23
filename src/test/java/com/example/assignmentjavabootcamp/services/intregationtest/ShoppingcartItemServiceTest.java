package com.example.assignmentjavabootcamp.services.intregationtest;

import com.example.assignmentjavabootcamp.exceptions.InvalidInputToShoppingcartException;
import com.example.assignmentjavabootcamp.exceptions.ShoppingcartItemNotFoundException;
import com.example.assignmentjavabootcamp.models.ShoppingcartItem;
import com.example.assignmentjavabootcamp.services.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ShoppingcartItemServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @Autowired
    ShoppingcartItemService shoppingcartItemService;

    ShoppingcartItem item;

    @BeforeEach
    public void setup() {
        shoppingcartItemService.addItem(1L, 1L, 15);
    }

    @Test
    public void whenAdd2ItemToCart_ShouldHave2AmountItem() {
        ShoppingcartItem item = shoppingcartItemService.addItem(1L, 1L, 2);
        assertEquals(17, item.getAmount());
    }

    @Test
    public void whenAdd1Item2TimesToCart_ShouldHave2AmountItem() {
        shoppingcartItemService.addItem(1L, 1L, 1);
        item = shoppingcartItemService.addItem(1L, 1L, 1);
        assertEquals(17, item.getAmount());
    }

    @Test
    public void whenRemove1Item_ShouldReduceAmountOfItem() {
        ShoppingcartItem item = shoppingcartItemService.removeItem(1L, 1L, 1);
        assertEquals(14, item.getAmount());
    }

    @Test
    public void whenRemove1Item2Times_ShouldReduceAmountOfItem() {
        shoppingcartItemService.removeItem(1L, 1L, 1);
        ShoppingcartItem addItem = shoppingcartItemService.removeItem(1L, 1L, 1);

        assertEquals(13, addItem.getAmount());
    }

    @Test
    public void whenRemoveAllItem_ShouldReturnNull() {
        ShoppingcartItem addItem = shoppingcartItemService.removeItem(1L, 1L, 15);
        assertNull(addItem);
    }

    @Test
    public void whenRemoveMorethanItemHave_ShouldThrowInvalidInputToShoppingcartException() {
        Assertions.assertThrows(InvalidInputToShoppingcartException.class,()->shoppingcartItemService.removeItem(1L,1L,200));
    }

    @Test
    public void whenAddMorethanItemHave_ShouldThrowInvalidInputToShoppingcartException() {
        Assertions.assertThrows(InvalidInputToShoppingcartException.class,()->shoppingcartItemService.addItem(1L,1L,150));
    }
}