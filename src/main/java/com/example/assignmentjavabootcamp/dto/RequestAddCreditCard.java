package com.example.assignmentjavabootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RequestAddCreditCard {

    private Long customerId;
    @NotBlank
    @Length(min = 16, max = 16)
    private String creditCardNumber;
    @NotBlank
    @Length(min = 3, max = 3)
    private String cvv;
    @NotBlank
    private String exp;

}
