package com.example.calculator.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CalculatorDto {

    private String firstValue;

    private String operator;

    private String lastValue;
}
