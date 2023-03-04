package com.example.calculator.service;

import com.example.calculator.dto.CalculatorDto;

import java.util.regex.Pattern;

public class ValidateService {

    public static boolean valid(CalculatorDto param) {
        String regex = "-?\\d+([,.]\\d+)?";
        return Pattern.matches(regex, param.getFirstValue()) &&
                Pattern.matches("[+-/*]", param.getOperator()) &&
                Pattern.matches(regex, param.getLastValue());
    }

}
