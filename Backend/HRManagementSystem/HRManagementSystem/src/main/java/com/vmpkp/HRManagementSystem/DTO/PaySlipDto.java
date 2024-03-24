package com.vmpkp.HRManagementSystem.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaySlipDto {

    private String firstName;
    private String lastName;
    private LocalDate EffectiveDate;
    private Double SalaryAmount;
    private int deduction;
    private int payable;
    private Double days;

}
