package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Autowired
    private ReadSheetService readSheetService;

    public String addAttendance(Attendance attendance){
        attendanceRepository.save(attendance);

        return "attendance added Successfully";
    }

    public String uploadFile(MultipartFile file) throws IOException {
       return readSheetService.upload(file);
    }
}
