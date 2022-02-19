package com.example.assignmentjavabootcamp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "creditcards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
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
