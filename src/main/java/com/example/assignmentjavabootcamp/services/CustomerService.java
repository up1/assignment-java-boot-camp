package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.dto.RequestShippingAddress;
import com.example.assignmentjavabootcamp.exceptions.CustomerNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CreditCardService creditCardService;

    public Customer getCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        throw new CustomerNotFoundException("Customer id : " + id + " was not found");
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer addCreditCard(Long id, CreditCard creditCard) {
        Customer customer = getCustomer(id);
        creditCard = creditCardService.addCreditCard(creditCard);
        customer.setCreditCard(creditCard);
        return saveCustomer(customer);
    }

    public Customer addShippingAddress(RequestShippingAddress address) {
        Customer customer = getCustomer(address.getCustomerId());
        customer.setAddress(address.getAddress());
        customer.setProvince(address.getProvince());
        customer.setZipCode(address.getZipCode());
        customer.setPhoneNumber(address.getPhoneNumber());

        return saveCustomer(customer);
    }
}
