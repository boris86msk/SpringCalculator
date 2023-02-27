package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import com.example.calculator.repository.CalculatorRepository;
import com.example.calculator.servise.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/get_res")
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (CalculatorEntity el : calculatorRepository.findAll()) {
            sb.append(el.toString());
            sb.append("/r");
        }
        return sb.toString();
    }
    @Autowired
    private CalculatorRepository calculatorRepository;

    @PostMapping("/calculate")
    public HttpStatus calculate(@RequestBody CalculatorDto calculatorDto) {
        CalculatorEntity calculatorEntity = new CalculatorEntity();
        calculatorEntity.setFirstValue(calculatorDto.getFirstValue());
        calculatorEntity.setLast_value(calculatorDto.getLastValue());
        calculatorEntity.setOperator(calculatorDto.getOperator());
        LocalDate localDate = LocalDate.now();
        calculatorEntity.setDataOperation(localDate);
        calculatorEntity.setResult(CalculatorService.calculate(calculatorEntity.getFirstValue(),
                calculatorEntity.getLast_value(), calculatorEntity.getOperator()));

        calculatorRepository.save(calculatorEntity);
        //HttpStatus.NOT_FOUND;
        return HttpStatus.OK;
    }

}
