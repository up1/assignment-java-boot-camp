package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.CreditCardNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCard getCreditCard(Long id) {
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(id);
        if (creditCardOptional.isPresent()) {
            return creditCardOptional.get();
        }
        throw new CreditCardNotFoundException("Creditcard id : " + id + " not found");
    }

    public CreditCard addCreditCard(@NonNull CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public void removeCreditCard(@NonNull CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }
}
