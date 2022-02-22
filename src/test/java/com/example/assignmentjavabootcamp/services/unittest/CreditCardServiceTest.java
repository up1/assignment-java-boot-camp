package com.example.assignmentjavabootcamp.services.unittest;

import com.example.assignmentjavabootcamp.exceptions.ExpireCreditCardException;
import com.example.assignmentjavabootcamp.models.CreditCard;
import com.example.assignmentjavabootcamp.repository.CreditCardRepository;
import com.example.assignmentjavabootcamp.services.CreditCardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceTest {

    @Mock
    CreditCardRepository creditCardRepository;

    @InjectMocks
    CreditCardService creditCardService;

    @Test
    public void whenAddCreditCard_ShouldReturnEncryptedCreditCard() {
        CreditCard card = new CreditCard("1234567890123458", "222", "09/26");
        Mockito.when(creditCardRepository.save(Mockito.any())).thenReturn(card);

        Assertions.assertThrows(NumberFormatException.class, () -> {
            CreditCard encryptedCard = creditCardService.addCreditCard(card);
            Long.valueOf(encryptedCard.getCreditCardNumber());
        });
    }

    @Test
    public void whenAddExpiredCreditCard_ShouldThrowExpireCreditCardException() {
        CreditCard card = new CreditCard("1234567890123458", "222", "09/21");
        Assertions.assertThrows(ExpireCreditCardException.class, () -> creditCardService.addCreditCard(card));
    }

}