package com.vmpkp.HRManagementSystem.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AttendanceSalaryDto {

    private Long employee_id;
    private LocalDate Date;
    private Double days;
    private String firstName;
    private String lastName;
    private Double salary;
}
