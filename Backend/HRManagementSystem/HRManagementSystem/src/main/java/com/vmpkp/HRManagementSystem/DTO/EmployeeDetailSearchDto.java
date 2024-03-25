package com.vmpkp.HRManagementSystem.DTO;

import lombok.Data;

@Data
public class EmployeeDetailSearchDto {

    private String firstName;
    private String lastName;
    private String departmentName;
    private String positionTitle;
    private Long employeeId;

}
