package com.example.calculator.mapper;

import com.example.calculator.dto.CalculatorDto;
import com.example.calculator.entity.CalculatorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CalculatorMapper {

    @Mapping(target = "dataOperation", source = "data")
    CalculatorEntity dtoToEntity(CalculatorDto calculatorDto);

    @Mapping(target = "data", source = "dataOperation")
    CalculatorDto entityToDto(CalculatorEntity calculatorEntity);


    @Mapping(target = "data", ignore = true)
    CalculatorDto entityToDtoNoData(CalculatorEntity calculatorEntity);

}
