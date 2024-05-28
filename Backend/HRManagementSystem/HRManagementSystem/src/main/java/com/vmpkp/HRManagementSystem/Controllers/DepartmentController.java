package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.Models.Department;
import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public String addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }


    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping("/get")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/delete/{departmentId}")
    public String deleteDepartment(@PathVariable Long departmentId){
        return departmentService.deleteDepartment(departmentId);
    }

//I did the upgrade.
}
