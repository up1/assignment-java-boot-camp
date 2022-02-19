package com.example.assignmentjavabootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "creditcards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Length(min = 16,max = 16)
    private String creditCardNumber;

    @NotBlank
    @Length(min = 3,max = 3)
    private String cvv;

    @NotNull
    private LocalDate exp;

    public CreditCard(String creditCardNumber, String cvv, LocalDate exp) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.exp = exp;
    }
}
