package com.example.calculator.mapping;

import com.example.calculator.base64encodedecode.Base64EncodeDecode;
import com.example.calculator.entity.CalculatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtractMapping {

    @Autowired
    private Base64EncodeDecode base64EncodeDecode;

    public List<CalculatorEntity> getMapping(List<CalculatorEntity> list) {
        for (CalculatorEntity el : list) {
            String decodeParam = base64EncodeDecode.getDecodeParam(el.getResult());
            el.setResult(decodeParam);
        }
        return list;
    }
}
