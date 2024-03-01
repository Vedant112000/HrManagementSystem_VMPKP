package com.vmpkp.HRManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PerformanceId;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee Employee;

    private Date EvaluationDate;

    private double rating;

    private String Comments;
}
