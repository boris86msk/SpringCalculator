package com.example.calculator.mapping;

import com.example.calculator.base64encodedecode.Base64EncodeDecode;
import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EntityMapping {

    @Autowired
    private Base64EncodeDecode base64EncodeDecode;

    public CalculatorEntity mapping(CalculatorDto dto) {
        String calculate = CalculatorService.calculate(dto);
        String encodeParam = base64EncodeDecode.getEncodeParam(calculate);

//        CalculatorEntity cn = new CalculatorEntity();
//        cn.setOperator(dto.getOperator());
//        cn.setFirstValue(dto.getFirstValue());
//        cn.setLastValue(dto.getLastValue());
//        cn.setDataOperation(LocalDate.now());
//        cn.setResult(encodeParam);

        return new CalculatorEntity()
                .setOperator(dto.getOperator())
                .setFirstValue(dto.getFirstValue())
                .setLastValue(dto.getLastValue())
                .setDataOperation(LocalDate.now())
                .setResult(encodeParam);
    }



}
