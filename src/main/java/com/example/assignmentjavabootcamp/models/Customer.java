package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstname;

    private String lastname;

    private String address;

    private String zipCode;

    private String province;

    private String phoneNumber;

    @OneToOne
    private Shoppingcart cart;

    public Customer(String firstname, String lastname, String address, String zipCode, String province, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zipCode = zipCode;
        this.province = province;
        this.phoneNumber = phoneNumber;
        this.cart = new Shoppingcart();
    }
}
