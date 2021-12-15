package com.ms.payroll.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment implements Serializable {
    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal() {
        return days * dailyIncome;
    }
}