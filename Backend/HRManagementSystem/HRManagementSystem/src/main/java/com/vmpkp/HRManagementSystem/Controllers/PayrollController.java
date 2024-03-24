package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.DTO.PaySlipDto;
import com.vmpkp.HRManagementSystem.Services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
