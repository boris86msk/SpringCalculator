package com.example.calculator.service;

import com.example.calculator.dto.CalculatorDto;

public class CalculatorService {
    public static String calculate(CalculatorDto param) {
        String result = "";
        if(ValidateService.valid(param)) {
            double leftMeaning = Double.parseDouble(param.getFirstValue());
            double rightMeaning = Double.parseDouble(param.getLastValue());
            String operator = param.getOperator();
            if (operator.contains("+")) {
                result = String.valueOf(leftMeaning + rightMeaning);
            } else if (operator.contains("-")) {
                result = String.valueOf(leftMeaning - rightMeaning);
            } else if (operator.contains("*")) {
                result = String.valueOf(leftMeaning * rightMeaning);
            } else if (operator.contains("/")) {
                if (rightMeaning == 0) {
                    throw new IllegalArgumentException("it is unacceptable to divide by zero");
                } else {
                    result = String.valueOf(leftMeaning / rightMeaning);
                }
            }
        } else {
            throw new IllegalArgumentException("invalid input parameters");
        }
        return result;
    }

}
