package com.example.assignmentjavabootcamp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class RequestAddToCart {
    @NotNull
    private Long customerId;
    @NotNull
    private Long productId;

    @NotNull
    private Integer amount;

}
