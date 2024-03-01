package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.Models.Salary;
import com.vmpkp.HRManagementSystem.Services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;


    @PostMapping("/add")
    public String addSalary(@RequestBody Salary salary){
        return salaryService.addSalary(salary);
    }

    @GetMapping("/{salaryId}")
    public Salary getSalary(@PathVariable Long salaryId){
        return salaryService.getSalary(salaryId);
    }

    @GetMapping("/all")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @DeleteMapping("/delete/{salaryId}")
    public String deleteSalary(@PathVariable Long salaryId){
        return salaryService.deleteSalary(salaryId);
    }

}
