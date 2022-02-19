package com.example.assignmentjavabootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    private String creditCardNumber;

    @NotNull
    @NotBlank
    private String cvv;
    @NotNull
    @NotBlank
    private LocalDateTime exp;

    @ManyToOne
    @NotNull
    private Customer owner;
}
