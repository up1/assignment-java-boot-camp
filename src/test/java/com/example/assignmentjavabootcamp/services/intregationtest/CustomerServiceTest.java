package com.example.assignmentjavabootcamp.services.intregationtest;

import com.example.assignmentjavabootcamp.dto.RequestShippingAddress;
import com.example.assignmentjavabootcamp.exceptions.CustomerNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import com.example.assignmentjavabootcamp.repository.CustomerRepository;
import com.example.assignmentjavabootcamp.services.CreditCardService;
import com.example.assignmentjavabootcamp.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CreditCardService creditCardService;


    @Test
    public void whenGetSavedCustomer_ShouldReturnCustomer() {
        Customer getCustomer = customerService.getCustomer(1L);
        assertEquals(1L, getCustomer.getCustomerId());

    }

    @Test
    public void whenGetUnsavedCustomer_ShouldThrowException() {
        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(2L));
    }

    @Test
    public void whenAddCreditCardToExistCustomer_ShouldSaveCreditCard() {
        CreditCard card = new CreditCard("1234567890123458", "222", "09/26");
        Customer customer = customerService.addCreditCard(1L, card);

        assertNotNull(customer.getCreditCard());
    }

    @Test
    public void whenAddShippingAddress_ShouldSaveToCustomer() {
        RequestShippingAddress address = new RequestShippingAddress(1L, "34 Moo8", "73110", "Bangkok", "0911111111");
        Customer c1 = customerService.addShippingAddress(address);

        assertEquals(c1.getProvince(), address.getProvince());
    }


}