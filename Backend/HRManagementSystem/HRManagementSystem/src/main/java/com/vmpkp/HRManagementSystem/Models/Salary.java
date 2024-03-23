package com.vmpkp.HRManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SalaryId;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee Employee;

    private int SalaryAmount;

    private int payable;

    private int deduction;

    private int EffectiveDate;

}
