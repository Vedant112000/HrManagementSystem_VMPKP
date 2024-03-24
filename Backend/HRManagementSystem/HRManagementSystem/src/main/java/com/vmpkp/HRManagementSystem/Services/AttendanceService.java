package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.DTO.AttendanceSalaryDto;
import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    private SalaryService salaryService;

    public AttendanceService(AttendanceRepository attendanceRepository, SalaryService salaryService) {
        this.attendanceRepository = attendanceRepository;
        this.salaryService = salaryService;
    }

    LocalDate date = LocalDate.now();
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

    public List<Attendance> allEmployeesAttendanceForCurrentMon(){
        List<Attendance> attendanceList = attendanceRepository.findByDate(date);
        return attendanceList;
    }

    //get attendance of all employees for current month

    public List<Attendance> allEmployeesAttendanceForCurrentMonth(){
        List<Attendance> attendanceList = attendanceRepository.findByDate(date);
        allEmployeesAttendanceForCurrentMonthDetailsToDto(attendanceList);

        return attendanceList;
    }

    public void allEmployeesAttendanceForCurrentMonthDetailsToDto(List<Attendance> attendanceList){


        List<AttendanceSalaryDto> attendanceSalaryDt = new ArrayList<>();
        for(Attendance attendance: attendanceList){
            AttendanceSalaryDto attendanceSalaryDto = new AttendanceSalaryDto();
            attendanceSalaryDto.setFirstName(attendance.getEmployee().getFirstName());
            attendanceSalaryDto.setEmployee_id(attendance.getEmployee().getEmployeeId());
            attendanceSalaryDto.setLastName(attendance.getEmployee().getLastName());
            attendanceSalaryDto.setDate(attendance.getDate());
            attendanceSalaryDto.setDays(attendance.getDays());
            attendanceSalaryDto.setSalary(attendance.getEmployee().getPosition().getSalary());
            attendanceSalaryDt.add(attendanceSalaryDto);
        }


        salaryService.getDetailsOfEmployeeForCurrentMonth(attendanceSalaryDt);

    }

}
