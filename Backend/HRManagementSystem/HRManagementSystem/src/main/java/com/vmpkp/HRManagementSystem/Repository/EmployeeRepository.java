package com.vmpkp.HRManagementSystem.Repository;

import com.vmpkp.HRManagementSystem.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//   find by Employee Name

    @Query("SELECT e.FirstName, e.LastName, e.department.DepartmentName, e.position.PositionTitle, e.EmployeeId FROM Employee e WHERE e.FirstName = :firstName")
    List<Object[]> findByFirstName(String firstName);
}
