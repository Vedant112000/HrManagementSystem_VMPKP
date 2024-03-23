package com.vmpkp.HRManagementSystem.Repository;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("SELECT a FROM Attendance a WHERE a.Date = :Date")
    List<Attendance> findByDate(LocalDate Date);
}
