package com.vmpkp.HRManagementSystem.Controllers;

import com.vmpkp.HRManagementSystem.Models.Position;
import com.vmpkp.HRManagementSystem.Services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("/add")
    public String addPosition(@RequestBody Position position){
        return positionService.addPosition(position);
    }

    @GetMapping("/{positionId}")
    public Position getPosition(@PathVariable Long positionId){
        return positionService.getPosition(positionId);
    }

    @GetMapping("/all")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @DeleteMapping("/delete/{positionId}")
    public String deletePosition(@PathVariable Long positionId){
        return positionService.deletePosition(positionId);
    }
}
