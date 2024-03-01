package com.vmpkp.HRManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`leave`")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LeaveId;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee Employee;

    private String LeaveType;

    private String StartDate;

    private String EndDate;

    private String Reason;

    private String Status;

}
