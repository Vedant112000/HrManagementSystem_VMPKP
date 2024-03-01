package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //add Employee

    public String addEmployee(Employee employee){
        employeeRepository.save(employee);

        return "Added Employee Successfully";
    }

    //get Employee

    public Employee getEmployeeById(Long EmployeeId){
        return employeeRepository.findById(EmployeeId).orElse(null);
    }

    //getAllEmployee

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //update employee profile

    public String updateEmployee(Long EmployeeId){
        Employee emp = getEmployeeById(EmployeeId);
        employeeRepository.save(emp);

        return "employee Updated";
    }

    //delete employee

    public String deleteEmployee(Long EmployeeId){
        employeeRepository.deleteById(EmployeeId);

        return "deleted employee successfully";
    }
}
