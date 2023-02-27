package com.example.calculator.repository;

import com.example.calculator.entity.CalculatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<CalculatorEntity, Long> {
}
