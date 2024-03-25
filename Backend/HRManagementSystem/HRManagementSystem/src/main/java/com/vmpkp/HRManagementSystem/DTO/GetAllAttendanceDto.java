package com.vmpkp.HRManagementSystem.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAllAttendanceDto {

    private String firstName;
    private String lastName;
    private LocalDate date;
    private Double days;
}
