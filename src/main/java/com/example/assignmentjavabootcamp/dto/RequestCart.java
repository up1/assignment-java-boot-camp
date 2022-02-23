package com.example.assignmentjavabootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RequestCart {
    @NotNull
    private Long customerId;
    @NotNull
    private Long productId;

    @NotNull
    private Integer amount;

}
