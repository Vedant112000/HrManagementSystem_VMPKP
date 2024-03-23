package com.vmpkp.HRManagementSystem.Repository;

import com.vmpkp.HRManagementSystem.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("SELECT e.employeeId, e.firstName, e.lastName, p.positionTitle, d.departmentName, a.days AS attendanceDays " +
//            "FROM Employee e " +
//            "JOIN Attendance a ON e.employeeId = a.employee.empId " +
//            "JOIN Position p ON e.position.positionId = p.positionId " +
//            "JOIN Department d ON e.department.departmentId = d.departmentId " +
//            "WHERE MONTH(a.date) = MONTH(CURRENT_DATE() - INTERVAL 1 MONTH) " +
//            "AND YEAR(a.date) = YEAR(CURRENT_DATE() - INTERVAL 1 MONTH)")
//    List<Object[]> findEmployeeAttendanceOfPreviousMonth();
//
//    List<Object[]> findByAttendanceDateMonthAndAttendanceDateYear(int month, int year);
}
