package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Salary;
import com.vmpkp.HRManagementSystem.Repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public String addSalary(Salary salary){
        salaryRepository.save(salary);

        return "Added salary Successfully";
    }

    public Salary getSalary(Long salaryId){
        return salaryRepository.findById(salaryId).orElse(null);
    }

    public List<Salary> getAllSalary(){
        return salaryRepository.findAll();
    }

    public String deleteSalary(Long salaryId){
        salaryRepository.deleteById(salaryId);

        return "Deleted Successfully";
    }
}
