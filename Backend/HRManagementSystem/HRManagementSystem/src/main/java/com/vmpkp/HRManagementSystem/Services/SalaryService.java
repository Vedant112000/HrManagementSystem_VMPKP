package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.DTO.AttendanceSalaryDto;
import com.vmpkp.HRManagementSystem.DTO.PaySlipDto;
import com.vmpkp.HRManagementSystem.Models.Salary;
import com.vmpkp.HRManagementSystem.Repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    //get day salary from its position
    //calculate salary of employee one by one and store it into salary table.
    //days * position.salary -> salary
    public String getDetailsOfEmployeeForCurrentMonth(List<AttendanceSalaryDto> attendanceSalaryDto){


        for(AttendanceSalaryDto attendanceSalaryDto1: attendanceSalaryDto){
            Salary salary = new Salary();
            salary.setEmployee_id(attendanceSalaryDto1.getEmployee_id());
            salary.setEffectiveDate(attendanceSalaryDto1.getDate());

            //calculation for total salary

            Double temp_salary = attendanceSalaryDto1.getSalary();
            Double temp_days = attendanceSalaryDto1.getDays();

            double total_salary = temp_salary * temp_days;

            salary.setSalaryAmount(total_salary);

            //calculation for payable & deduction
            double temp_deduction = total_salary * (1.0 / 100.0);
            int temp_deduction_int = (int) temp_deduction;

            salary.setDeduction(temp_deduction_int);

            int temp_total_salary = (int) total_salary;

            int temp_payable = temp_total_salary - temp_deduction_int;
            salary.setPayable(temp_payable);

            salaryRepository.save(salary);
        }

        return "Calculated Salary and stored into the db";
    }


    //Get Salary Details for employee & month mentioned.

        public Salary getLatestSalaryDetailForSpecifiedEmployee(Long employeeId, LocalDate date){
            return salaryRepository.findSalaryByEmployeeId(employeeId, date);
        }

    //Get all current year salary for specific employee.

        public List<Salary> getAllSalaryForCurrentYear(Long employeeId, LocalDate date){
            return salaryRepository.findAllSalaryByEmployeeIdForCurrentYear(employeeId, date);
        }

    public List<Salary> findAllSalaryByDate(LocalDate date){
        return salaryRepository.findAllSalaryByDate(date);
    }

    //Get combined payroll for all the employee of the month specified(for the use of admin).
    //for this I would need to get list of salary for the month.
    //Get combined payroll for all the employee of the current month(for the use of admin).
        public Double sendCombinedPayrollForTheSpecifiedMonth(LocalDate date){
            List<Salary> allSalary = findAllSalaryByDate(date);

            Double payroll = 0.0;

            for(Salary salary: allSalary){
                payroll += salary.getSalaryAmount();
            }

            return payroll;
        }




}
