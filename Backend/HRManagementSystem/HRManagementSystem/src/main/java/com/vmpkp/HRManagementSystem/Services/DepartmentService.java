package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Department;
import com.vmpkp.HRManagementSystem.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public String addDepartment(Department department){
        departmentRepository.save(department);

        return "Department added successfully";
    }

    public Department getDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public String deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);

        return "deleted Successfully";
    }
}
