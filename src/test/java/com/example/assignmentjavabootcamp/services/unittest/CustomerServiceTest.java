package com.example.assignmentjavabootcamp.services.unittest;

import com.example.assignmentjavabootcamp.dto.RequestShippingAddress;
import com.example.assignmentjavabootcamp.exceptions.CustomerNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import com.example.assignmentjavabootcamp.repository.CustomerRepository;
import com.example.assignmentjavabootcamp.services.CreditCardService;
import com.example.assignmentjavabootcamp.services.CustomerService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Mock
    CreditCardService creditCardService;

    @Mock
    CreditCardRepository creditCardRepository;

    Customer customer;

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
        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

    }

    @Test
    public void whenGetSavedCustomer_ShouldReturnCustomer() {
        Customer getCustomer = customerService.getCustomer(1L);
        assertEquals(customer.getCustomerId(), getCustomer.getCustomerId());

    }

    @Test
    public void whenGetUnsavedCustomer_ShouldThrowException() {
        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(1L));
    }

    @Test
    public void whenAddCreditCardToExistCustomer_ShouldSaveCreditCard() {

        CreditCard card = new CreditCard("1234567890123458", "222", "09/26");
        Mockito.when(creditCardService.addCreditCard(Mockito.any())).thenReturn(card);
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);

        Customer customer = customerService.addCreditCard(1L, card);

        assertNotNull(customer.getCreditCard());
    }

    @Test
    public void whenAddShippingAddress_ShouldSaveToCustomer() {
        RequestShippingAddress address = new RequestShippingAddress(1L,"34 Moo8","73110","Bangkok","0911111111");
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
       Customer c1 = customerService.addShippingAddress(address);

        assertEquals(c1.getProvince(), address.getProvince());
    }


}