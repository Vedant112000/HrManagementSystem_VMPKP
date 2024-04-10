package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.DTO.PaySlipDto;
import com.vmpkp.HRManagementSystem.Services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("/get/slips")
    public List<PaySlipDto> sendPaySlipDetails(){
        return payrollService.sendPaySlipData();
    }

    @PostMapping("/send-emails")
    public String sendEmails(){
        payrollService.generateAndSendEmail();

        return "Emails Sent Successfully";
    }

}
