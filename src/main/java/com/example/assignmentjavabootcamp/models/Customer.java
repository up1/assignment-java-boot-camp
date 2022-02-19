package com.example.assignmentjavabootcamp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    private String address;

    @Length(min = 5,max = 5)
    @NotNull
    @NotBlank
    private String zipCode;

    private String province;

    @Length(min = 10,max = 10)
    @NotNull
    @NotBlank
    private String phoneNumber;


    public Customer(String firstname, String lastname, String address, String zipCode, String province, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zipCode = zipCode;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }
}
