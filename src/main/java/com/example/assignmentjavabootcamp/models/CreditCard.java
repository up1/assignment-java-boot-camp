package com.example.assignmentjavabootcamp.models;

import com.example.assignmentjavabootcamp.exceptions.ExpireCreditCardException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "creditcards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String creditCardNumber;

    @NotBlank
    private String last4digit;

    @NotBlank
    @Length(min = 3, max = 3)
    private String cvv;

    @NotNull
    private LocalDate exp;

    public CreditCard(String creditCardNumber, String cvv, String exp) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.exp = convertDateStringToLocalDate(exp);
        this.last4digit = creditCardNumber.substring(12, 16);
    }

    private LocalDate convertDateStringToLocalDate(String exp) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("MM/yy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 31)
                .toFormatter();

        return LocalDate.parse(exp, formatter);
    }
}
