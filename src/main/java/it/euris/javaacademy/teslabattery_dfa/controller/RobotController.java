package it.euris.javaacademy.teslabattery_dfa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery_dfa.data.dto.RobotsDTO;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.service.RobotsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/robots")
@SecurityRequirement(name = "authentication")
public class RobotController {

    RobotsService robotsService;

    @GetMapping("/v1")
    @Operation(description = """
      This method is used to retrieve all the robots from the database<br>
      """)
    public List<RobotsDTO> getAllRobots() {
        return robotsService.findAll().stream().map(Robots::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
      This method is used to insert a robot in the database<br>
      """)
    public RobotsDTO saveRobot(@RequestBody RobotsDTO robotsDTO){
        try{
            Robots robot = robotsDTO.toModel();
            return robotsService.insert(robot).toDto();
        }
        catch(IdMustBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
      This method is used to update a robot in the database<br>
      """)
    public RobotsDTO updateRobot(@RequestBody RobotsDTO robotsDTO){
        try{
            Robots robot = robotsDTO.toModel();
            return robotsService.update(robot).toDto();
        }
        catch(IdMustNotBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/v1/{id}")
    @Operation(description = """
      This method is used to delete a robot in the database by id<br>
      """)
    public Boolean deleteRobotById(@PathVariable("id") Integer id) {
        return robotsService.deleteById(id);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
      This method is used to get a robot in the database by id<br>
      """)
    public RobotsDTO getRobotById(@PathVariable("id") Integer id) {
        return robotsService.findById(id).toDto();
    }
}
