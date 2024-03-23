package com.vmpkp.HRManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AttendanceId;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee Employee;

    private LocalDate Date;

    private Double days;
}
