package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.DTO.GetAllAttendanceDto;
import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Models.Employee;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import com.vmpkp.HRManagementSystem.Services.AttendanceService;
import com.vmpkp.HRManagementSystem.Services.ReadSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/upload")
    public String uploadAttendance(@RequestParam MultipartFile file) throws IOException {

        attendanceService.uploadFile(file);
        return "File Successfully Uploaded";
    }

    @GetMapping("/getAll")
    public List<GetAllAttendanceDto> getAllEmployeeAttendanceForMonth(){
        List<Attendance> attendanceList = attendanceService.allEmployeesAttendanceForCurrentMonth();
        List<GetAllAttendanceDto> getAllAttendanceDtoList = new ArrayList<>();
        for(Attendance attendance: attendanceList){
            GetAllAttendanceDto getAllAttendanceDto = new GetAllAttendanceDto();

            getAllAttendanceDto.setFirstName(attendance.getEmployee().getFirstName());
            getAllAttendanceDto.setLastName(attendance.getEmployee().getLastName());
            getAllAttendanceDto.setDate(attendance.getDate());
            getAllAttendanceDto.setDays(attendance.getDays());

            getAllAttendanceDtoList.add(getAllAttendanceDto);
        }

        return getAllAttendanceDtoList;
    }

}
