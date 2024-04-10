package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.DTO.AttendanceSalaryDto;
import com.vmpkp.HRManagementSystem.DTO.PaySlipDto;
import com.vmpkp.HRManagementSystem.Models.Attendance;
import com.vmpkp.HRManagementSystem.Models.Salary;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    private AttendanceService attendanceService;
    private SalaryService salaryService;

    private SendEmailService sendEmailService;

    public PayrollService(AttendanceService attendanceService, SalaryService salaryService, SendEmailService sendEmailService) {
        this.attendanceService = attendanceService;
        this.salaryService = salaryService;
        this.sendEmailService = sendEmailService;
    }



    //Get AttendanceDto Details to Salary Service layer
    public List<AttendanceSalaryDto> sendDetailsToSalaryServicePayslipMethod(){
        List<Attendance> attendanceList = attendanceService.allEmployeesAttendanceForCurrentMon();
        List<AttendanceSalaryDto> attendanceSalaryDt = new ArrayList<>();
        for(Attendance attendance: attendanceList){
            AttendanceSalaryDto attendanceSalaryDto = new AttendanceSalaryDto();
            attendanceSalaryDto.setFirstName(attendance.getEmployee().getFirstName());
            attendanceSalaryDto.setEmployee_id(attendance.getEmployee().getEmployeeId());
            attendanceSalaryDto.setLastName(attendance.getEmployee().getLastName());
            attendanceSalaryDto.setDate(attendance.getDate());
            attendanceSalaryDto.setDays(attendance.getDays());
            attendanceSalaryDto.setSalary(attendance.getEmployee().getPosition().getSalary());
            attendanceSalaryDto.setEmail(attendance.getEmployee().getEmail());
            attendanceSalaryDt.add(attendanceSalaryDto);
        }

        return attendanceSalaryDt;
    }


    //get all the details of salary, attendance and employee

    public List<PaySlipDto> sendPaySlipData(){

        List<PaySlipDto> paySlipDtoList = new ArrayList<>();

        //getting attendance, employee details

        List<AttendanceSalaryDto> attendanceSalaryDtos = sendDetailsToSalaryServicePayslipMethod();

        //get salary details for the employee
        LocalDate date = LocalDate.now();
        List<Salary> allSalary = salaryService.findAllSalaryByDate(date);

        //now set all the details to the dto's

        int i = 0;

        for(AttendanceSalaryDto attendanceSalaryDto: attendanceSalaryDtos){
            PaySlipDto paySlipDto = new PaySlipDto();

            paySlipDto.setFirstName(attendanceSalaryDto.getFirstName());
            paySlipDto.setLastName(attendanceSalaryDto.getLastName());
            paySlipDto.setEffectiveDate(attendanceSalaryDto.getDate());
            paySlipDto.setDays(attendanceSalaryDto.getDays());
            paySlipDto.setEmployeeId(attendanceSalaryDto.getEmployee_id());
            paySlipDto.setSalaryAmount(allSalary.get(i).getSalaryAmount());
            paySlipDto.setDeduction(allSalary.get(i).getDeduction());
            paySlipDto.setPayable(allSalary.get(i).getPayable());
            paySlipDto.setEmail(attendanceSalaryDto.getEmail());

            i += 1;

            paySlipDtoList.add(paySlipDto);
        }


        return paySlipDtoList;
    }

    public void generateAndSendEmail(){
        List<PaySlipDto> paySlipDtoList = sendPaySlipData();
        sendEmailService.generateAndSendPayslipEmails(paySlipDtoList);
    }
}
