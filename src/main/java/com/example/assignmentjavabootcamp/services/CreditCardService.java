package com.example.assignmentjavabootcamp.services;

import com.example.assignmentjavabootcamp.exceptions.ExpireCreditCardException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCard addCreditCard(@NonNull CreditCard creditCard) {
        isExpired(creditCard);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        creditCard.setCreditCardNumber(passwordEncoder.encode(creditCard.getCreditCardNumber()));
        creditCard = creditCardRepository.save(creditCard);
        log.info("save credit card success");
        return creditCard;
    }

    private boolean isExpired(CreditCard card) {
        LocalDate dateExpired = card.getExp();
        if (dateExpired.isBefore(LocalDate.now())) {
            throw new ExpireCreditCardException("Credit card is Expired");
        }
        return false;
    }

}
