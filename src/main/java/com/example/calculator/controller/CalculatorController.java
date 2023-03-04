package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import com.example.calculator.mapper.CalculatorMapper;
import com.example.calculator.repository.CalculatorRepository;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.calculator.calculatconst.Calc.CALCULATE;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private CalculatorMapper calculatorMapper;


    @Autowired
    private CalculatorRepository calculatorRepository;


    @GetMapping("/get_res_param")
    public List<CalculatorEntity> testGet() {
        //calculatorRepository.findById();
        return calculatorRepository.findAll();
    }

    @GetMapping("/get_res")
    public List<CalculatorEntity> getResult() {
        List<CalculatorEntity> all = calculatorRepository.findAll();
        return calculatorService.getMapping(all);
    }


    @PostMapping(CALCULATE)
    public HttpStatus calculate(@RequestBody CalculatorDto calculatorDto) {
        CalculatorDto calculate = calculatorService.calculate(calculatorDto);
        calculatorRepository.save(calculatorMapper.dtoToEntity(calculate));
        //calculatorRepository.save(entityMapping.mapping(calculatorDto));
        return HttpStatus.OK;
    }

    //modelMapper

}
