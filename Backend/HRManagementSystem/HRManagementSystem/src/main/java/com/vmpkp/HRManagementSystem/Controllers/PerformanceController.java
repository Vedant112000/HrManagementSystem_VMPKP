package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.Models.Performance;
import com.vmpkp.HRManagementSystem.Services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;


    @PostMapping("/add")
    public String addPerformance(@RequestBody Performance performance){
        return performanceService.addPerformance(performance);
    }

    @GetMapping("/{performanceId}")
    public Performance getPerformance(@PathVariable Long performanceId){
        return performanceService.getPerformance(performanceId);
    }

    @GetMapping("/all")
    public List<Performance> getAllPerformance(){
        return performanceService.getAllPerformance();
    }

    @DeleteMapping("/delete/{performanceId}")
    public String deletePerformance(@PathVariable Long performanceId){
        return performanceService.deletePerformance(performanceId);
    }
}
