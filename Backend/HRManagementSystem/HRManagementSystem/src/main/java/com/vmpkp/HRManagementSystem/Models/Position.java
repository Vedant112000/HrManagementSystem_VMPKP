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
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Position_Id;

    private String PositionTitle;

    private int salary;

    private String JobDescription;

    @OneToMany(mappedBy = "Position_Id")
    private List<Employee> employees;


}
