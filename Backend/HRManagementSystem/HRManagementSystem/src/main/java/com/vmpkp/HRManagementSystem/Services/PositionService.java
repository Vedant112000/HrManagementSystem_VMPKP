package com.vmpkp.HRManagementSystem.Services;

import com.vmpkp.HRManagementSystem.Models.Position;
import com.vmpkp.HRManagementSystem.Repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    public String addPosition(Position position){
            positionRepository.save(position);

            return "Added Position Successfully";
    }

    public Position getPosition(Long positionId){
        return positionRepository.findById(positionId).orElse(null);
    }

    public List<Position> getAllPosition(){
        return positionRepository.findAll();
    }

    public String deletePosition(Long PositionId){
        positionRepository.deleteById(PositionId);

        return "Deleted Position Successfully";
    }
}
