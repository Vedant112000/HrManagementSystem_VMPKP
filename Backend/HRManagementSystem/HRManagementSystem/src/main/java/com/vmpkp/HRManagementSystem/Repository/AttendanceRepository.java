package com.vmpkp.HRManagementSystem.Repository;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("SELECT a FROM Attendance a WHERE FUNCTION('YEAR', a.Date) = FUNCTION('YEAR', :Date) AND FUNCTION('MONTH', a.Date) = FUNCTION('MONTH', :Date)")
    List<Attendance> findByDate(LocalDate Date);
}
