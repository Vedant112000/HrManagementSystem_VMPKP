package com.vmpkp.HRManagementSystem.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EmployeeId;

    private String FirstName;

    private String LastName;

    private String Gender;

    private String Email;

    private String Phone;

    private String Address;

    private String HireDate;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;


    @JsonIgnore
    @OneToMany(mappedBy = "Employee")
    private List<Attendance> getAttendance;

}
