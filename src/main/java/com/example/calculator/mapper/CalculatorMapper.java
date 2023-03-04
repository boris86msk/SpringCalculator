package com.example.calculator.mapper;

import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    @Mapping(target = "dataOperation", source = "data")
    //@Mapping(target = "dataOperation", ignore = true) //игнор полей
    CalculatorEntity dtoToEntity(CalculatorDto calculatorDto);
}
