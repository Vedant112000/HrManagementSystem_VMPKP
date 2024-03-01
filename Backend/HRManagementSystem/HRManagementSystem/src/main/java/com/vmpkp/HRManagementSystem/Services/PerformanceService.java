package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Performance;
import com.vmpkp.HRManagementSystem.Repository.PerformanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public String addPerformance(Performance performance){
        performanceRepository.save(performance);

        return "Performance added successfully";
    }

    public Performance getPerformance(Long PerformanceId){
        return performanceRepository.findById(PerformanceId).orElse(null);
    }

    public List<Performance> getAllPerformance(){
        return performanceRepository.findAll();
    }

    public String deletePerformance(Long PerformanceId){
        performanceRepository.deleteById(PerformanceId);

        return "deleted Successfully";
    }
}
