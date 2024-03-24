package com.vmpkp.HRManagementSystem.Repository;

import com.vmpkp.HRManagementSystem.Models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    @Query("SELECT s FROM Salary s " +
            "WHERE FUNCTION('MONTH', s.EffectiveDate) = FUNCTION('MONTH', :date) " +
            "AND FUNCTION('YEAR', s.EffectiveDate) = FUNCTION('YEAR', :date) " +
            "AND s.employee_id = :employee_id")
    Salary findSalaryByEmployeeId(Long employee_id, LocalDate date);

    @Query("SELECT s FROM Salary s " +
            "WHERE FUNCTION('YEAR', s.EffectiveDate) = FUNCTION('YEAR', :date) " +
            "AND s.employee_id = :employee_id")
    List<Salary> findAllSalaryByEmployeeIdForCurrentYear(Long employee_id, LocalDate date);

    @Query("SELECT s FROM Salary s " +
            "WHERE FUNCTION('YEAR', s.EffectiveDate) = YEAR(:date) " +
            "AND FUNCTION('MONTH', s.EffectiveDate) = MONTH(:date)")
    List<Salary> findAllSalaryByDate(LocalDate date);
}
