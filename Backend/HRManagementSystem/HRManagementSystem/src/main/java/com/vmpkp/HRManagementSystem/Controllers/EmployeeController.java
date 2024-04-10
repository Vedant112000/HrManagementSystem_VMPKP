package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.DTO.EmployeeDetailSearchDto;
import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{EmployeeId}")
    public Employee getEmployeeById(@PathVariable Long EmployeeId){
        return employeeService.getEmployeeById(EmployeeId);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    public String deleteEmployeeById(@PathVariable Long EmployeeId){
        return employeeService.deleteEmployee(EmployeeId);
    }

    @GetMapping("/get/byName")
    public List<EmployeeDetailSearchDto> getEmployeeByName(@RequestParam String firstName){
        return employeeService.getEmployeeByName(firstName);
    }
}
