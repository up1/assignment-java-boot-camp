package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank(message = "size should not be blank")
    private String size;

    @NotBlank
    @NotNull
    private Double price;

    @NotBlank
    @NotNull
    private Integer amount;

    public Product(String name, String size, Double price, Integer amount) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.amount = amount;
    }
}
