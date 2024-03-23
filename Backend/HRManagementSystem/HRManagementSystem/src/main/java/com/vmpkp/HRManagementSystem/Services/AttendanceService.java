package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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

    // Service that takes file and stores attendance into db
    public String uploadFile(MultipartFile file) throws IOException {
       return readSheetService.upload(file);
    }

    //get attendance of all employees for current month

    public List<Attendance> allEmployeesAttendanceForCurrentMonth(){
        LocalDate date = LocalDate.now();


        return attendanceRepository.findByDate(date);
    }


}
