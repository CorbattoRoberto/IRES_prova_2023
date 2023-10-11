package it.euris.javaacademy.teslabattery.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery.data.dto.ComponentDTO;
import it.euris.javaacademy.teslabattery.data.dto.RobotDTO;
import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.data.entity.Robot;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.service.RobotService;
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

    RobotService robotService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all  Robots from data base.
            """)
    public List<RobotDTO> getAllRobots() {
        return robotService.findAll().stream().map(Robot::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Robot to data base.
            """)
    public RobotDTO saveRobot(@RequestBody RobotDTO robotDTO) {
        try {
            Robot robot = robotDTO.toModel();
            return robotService.insert(robot).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update an existing Robot in data base.
            """)
    public RobotDTO updateRobot(@RequestBody RobotDTO robotDTO) {
        try {
            Robot robot = robotDTO.toModel();
            return robotService.update(robot).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a Robot from data base using robotId as parameter.
            """)
    public Boolean deleteRobotById(@PathVariable("id") Integer robotId) {
        return robotService.deleteById(robotId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve Robot  from data base using robotId as parameter.
            """)
    public RobotDTO getRobotById(@PathVariable("id") Integer robotId) {
        return robotService.findById(robotId).toDto();
    }
}
