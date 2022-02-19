package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.CreaditCardNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.models.Customer;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public void addCreditCard(@NotNull Customer customer, @NotNull CreditCard creditCard) {
        creditCard.setOwner(customer);
        creditCardRepository.save(creditCard);
    }

    public void removeCreditCard(@NotNull CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }

    public CreditCard getCreditCard(@NotNull Long ownerId) {
        Optional<CreditCard> creditCardOptional = creditCardRepository.findByOwnerCustomerId(ownerId);
        if (creditCardOptional.isPresent()) {
            return creditCardOptional.get();
        }
        throw new CreaditCardNotFoundException("CreditCard's owner id : " + ownerId + " not found");
    }
}
