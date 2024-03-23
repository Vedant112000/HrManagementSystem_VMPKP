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
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    private String PositionTitle;

    private int salary;

    private String JobDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private List<Employee> employees;


}
