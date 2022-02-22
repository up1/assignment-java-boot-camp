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

    @NotBlank
    private String name;

    @NotBlank
    private String size;

    @NotNull
    private Double price;

    @NotBlank
    private String typeOfSize;

    @NotBlank
    private String color;

    @NotNull
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
