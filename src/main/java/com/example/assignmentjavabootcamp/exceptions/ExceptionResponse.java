package com.example.assignmentjavabootcamp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private String reason;
    private LocalDateTime timeStamp;
    private HttpStatus httpStatus;
}
