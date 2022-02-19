package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.CreditCardNotFoundException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        creditCard.setCreditCardNumber(passwordEncoder.encode(creditCard.getCreditCardNumber()));
        creditCard = creditCardRepository.save(creditCard);
        log.info("save credit card success");
        return creditCard;
    }

    public void removeCreditCard(@NonNull CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }
}
