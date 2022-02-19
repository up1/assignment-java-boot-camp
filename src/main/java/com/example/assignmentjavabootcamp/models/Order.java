package com.example.assignmentjavabootcamp.models;


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
@Table(name = "Orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private LocalDateTime buyAt;

    @NotNull
    @NotBlank
    private String payBy;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer orderOwner;

    public Order(LocalDateTime buyAt, String payBy, Customer customer) {
        this.buyAt = buyAt;
        this.payBy = payBy;
        this.orderOwner = customer;
    }
}
