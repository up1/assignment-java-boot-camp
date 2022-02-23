package com.example.assignmentjavabootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RequestShippingAddress {

    @NotNull
    private Long customerId;
    @NotBlank
    private String address;
    @NotBlank
    @Length(min = 5, max = 5)
    private String zipCode;
    @NotBlank
    private String province;
    @NotBlank
    @Length(min = 10, max = 10)
    private String phoneNumber;
}
