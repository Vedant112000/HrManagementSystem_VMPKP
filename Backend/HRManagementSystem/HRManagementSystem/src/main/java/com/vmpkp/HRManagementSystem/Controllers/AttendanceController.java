package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import com.vmpkp.HRManagementSystem.Services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/add")
    public String addAttendance(@RequestBody Attendance attendance){
        return attendanceService.addAttendance(attendance);
    }

}
