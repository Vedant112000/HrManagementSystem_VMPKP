package com.vmpkp.HRManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SalaryId;


    @Column(name = "employee_id")
    private Long employee_id;

    private Double SalaryAmount;

    private int payable;

    private int deduction;

    private LocalDate EffectiveDate;

}
