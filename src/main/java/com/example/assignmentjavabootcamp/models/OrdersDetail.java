package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class OrdersDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @NotNull
    @NotBlank
    private String productName;

    @NotNull
    @NotBlank
    private Integer amount;

    @NotNull
    @NotBlank
    private Double price;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;
}
