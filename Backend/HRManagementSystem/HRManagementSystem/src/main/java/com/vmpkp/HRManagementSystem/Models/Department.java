package com.vmpkp.HRManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Department_Id;

    private String DepartmentName;

    @OneToMany(mappedBy = "Department_Id")
    private List<Employee> employees;

}
