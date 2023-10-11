package it.euris.javaacademy.teslabattery.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery.data.dto.ComponentDTO;
import it.euris.javaacademy.teslabattery.data.dto.SupervisorDTO;
import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.data.entity.Supervisor;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.service.SupervisorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/supervisors")
@SecurityRequirement(name = "authentication")
public class SupervisorController {

    SupervisorService supervisorService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all  Supervisors from data base.
            """)
    public List<SupervisorDTO> getAllSupervisors() {
        return supervisorService.findAll().stream().map(Supervisor::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Supervisor to data base.
            """)
    public SupervisorDTO saveSupervisors(@RequestBody SupervisorDTO supervisorDTO) {
        try {
            Supervisor supervisor = supervisorDTO.toModel();
            return supervisorService.insert(supervisor).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update an existing Supervisor in data base.
            """)
    public SupervisorDTO updateSupervisors(@RequestBody SupervisorDTO supervisorDTO) {
        try {
            Supervisor supervisor = supervisorDTO.toModel();
            return supervisorService.update(supervisor).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a Supervisor from data base using supervisorId as parameter.
            """)
    public Boolean deleteSupervisorById(@PathVariable("id") Integer supervisorId) {
        return supervisorService.deleteById(supervisorId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve Components  from data base using supervisorId as parameter.
            """)
    public SupervisorDTO getSupervisorById(@PathVariable("id") Integer supervisorId) {
        return supervisorService.findById(supervisorId).toDto();
    }
}
