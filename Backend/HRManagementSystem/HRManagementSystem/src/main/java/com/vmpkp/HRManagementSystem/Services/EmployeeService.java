package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.DTO.EmployeeDetailSearchDto;
import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //add Employee

    public Employee addEmployee(Employee employee){
        Employee empDetails = employeeRepository.save(employee);

        return empDetails;
    }

    //get Employee

    public Employee getEmployeeById(Long EmployeeId){
        return employeeRepository.findById(EmployeeId).orElse(null);
    }

    //getAllEmployee

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //get Employee By Name

    public List<EmployeeDetailSearchDto> getEmployeeByName(String firstName){

        List<EmployeeDetailSearchDto> employeeDetailSearchDtoList = new ArrayList<>();
        List<Employee> employees = employeeRepository.findByFirstName(firstName);

        for(Employee employee : employees){
            EmployeeDetailSearchDto employeeDetailSearchDto = new EmployeeDetailSearchDto();

            employeeDetailSearchDto.setEmployeeId(employee.getEmployeeId());
            employeeDetailSearchDto.setFirstName(employee.getFirstName());
            employeeDetailSearchDto.setLastName(employee.getLastName());
            employeeDetailSearchDto.setDepartmentName(employee.getDepartment().getDepartmentName());
            employeeDetailSearchDto.setPositionTitle(employee.getPosition().getPositionTitle());

            employeeDetailSearchDtoList.add(employeeDetailSearchDto);
        }

        return employeeDetailSearchDtoList;
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
