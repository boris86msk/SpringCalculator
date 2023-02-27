package com.example.calculator.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name="calculator_table")
@Data
@ToString
public class CalculatorEntity {

    @Id
    @SequenceGenerator(name="calculator_tableSequence", sequenceName="calculator_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="calculator_tableSequence")
    @Column(name = "id")
    private Long id;

    @Column(name="first_value")
    private String firstValue;

    @Column(name="operator")
    private String operator;

    @Column(name="last_value")
    private String last_value;

    @Column(name="result_operation")
    private String result;

    @Column(name="data_operation")
    private LocalDate dataOperation;
}
