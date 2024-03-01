package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public String addAttendance(Attendance attendance){
        attendanceRepository.save(attendance);

        return "attendance added Successfully";
    }
}
