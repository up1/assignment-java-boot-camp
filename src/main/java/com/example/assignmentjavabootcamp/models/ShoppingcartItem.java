package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shoppingcart_items")
public class ShoppingcartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shoppingcartItemId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "product_id")
    private Product product;

    @NotBlank
    private Integer amount;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "owner_id")
    private Customer customer;

    public ShoppingcartItem(Product product, Integer amount, Customer customer) {
        this.product = product;
        this.amount = amount;
        this.customer = customer;
    }
}
