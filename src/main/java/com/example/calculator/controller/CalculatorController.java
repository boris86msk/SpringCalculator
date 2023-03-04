package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import com.example.calculator.mapping.EntityMapping;
import com.example.calculator.mapping.ExtractMapping;
import com.example.calculator.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private ExtractMapping extractMapping;

    @Autowired
    private CalculatorRepository calculatorRepository;

    @Autowired
    private EntityMapping entityMapping;

    @GetMapping("/get_res_param")
    public List<CalculatorEntity> testGet() {
        return calculatorRepository.findAll();
    }

    @GetMapping("/get_res")
    public List<CalculatorEntity> getResult() {
        List<CalculatorEntity> all = calculatorRepository.findAll();
        return extractMapping.getMapping(all);
    }


    @PostMapping("/calculate")
    public HttpStatus calculate(@RequestBody CalculatorDto calculatorDto) {
        calculatorRepository.save(entityMapping.mapping(calculatorDto));
        return HttpStatus.OK;
    }

}
