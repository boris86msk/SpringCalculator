package com.example.calculator.service;

import com.example.calculator.base64encodedecode.Base64EncodeDecode;
import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class CalculatorService {

    @Autowired
    private Base64EncodeDecode base64EncodeDecode;

    public CalculatorDto calculate(CalculatorDto param) {
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

        param.setResult(base64EncodeDecode.getEncodeParam(result));
        param.setData(LocalDate.now());

        return param;
    }

    public List<CalculatorEntity> getMapping(List<CalculatorEntity> list) {
        for (CalculatorEntity el : list) {
            String decodeParam = base64EncodeDecode.getDecodeParam(el.getResult());
            el.setResult(decodeParam);
        }
        return list;
    }

}
