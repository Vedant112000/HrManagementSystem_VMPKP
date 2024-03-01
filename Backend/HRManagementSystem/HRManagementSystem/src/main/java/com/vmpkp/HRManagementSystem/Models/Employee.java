package com.vmpkp.HRManagementSystem.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JoinColumn(name = "Department_Id")
    private Department Department_Id;

    @ManyToOne
    @JoinColumn(name = "Position_Id")
    private Position Position_Id;

}
