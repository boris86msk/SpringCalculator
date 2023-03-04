package com.example.calculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name="calculator")
@Data
@ToString
public class CalculatorEntity {

    @Id
    @SequenceGenerator(name="calculatorSequence", sequenceName="calculator_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calculatorSequence")
    @Column(name = "id")
    private Long id;

    @Column(name="first_value")
    private String firstValue;

    @Column(name="operator")
    private String operator;

    @Column(name="last_value")
    private String lastValue;

    @Column(name="result_operation")
    private String result;

    @Column(name="data_operation")
    private LocalDate dataOperation;
}
