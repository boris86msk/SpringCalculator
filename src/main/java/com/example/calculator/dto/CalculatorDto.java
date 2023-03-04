package com.example.calculator.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalculatorDto {

    private String firstValue;

    private String operator;

    private String lastValue;

    private LocalDate data;

    private String result;
}
