package com.example.assignmentjavabootcamp.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private LocalDateTime buyAt;

    @NotBlank
    private String payBy;

    @NotBlank
    private String shippingAddress;

    @NotBlank
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer orderOwner;

    public Order(LocalDateTime buyAt, String payBy, String address, Customer customer) {
        this.buyAt = buyAt;
        this.payBy = payBy;
        this.orderOwner = customer;
        this.shippingAddress = address;
    }
}
