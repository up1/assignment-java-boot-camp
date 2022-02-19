package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String size;

    @NotNull
    @NotBlank
    private Double price;

    @NotNull
    @NotBlank
    private String typeOfSize;

    @NotNull
    @NotBlank
    private String color;

    @NotNull
    @NotBlank
    private Integer amount;

    public Product(String name, String size, Double price, String typeOfSize, String color, Integer amount) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.typeOfSize = typeOfSize;
        this.color = color;
        this.amount = amount;
    }
}
