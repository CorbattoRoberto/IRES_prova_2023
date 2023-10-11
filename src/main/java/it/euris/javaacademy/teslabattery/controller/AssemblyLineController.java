package it.euris.javaacademy.teslabattery.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery.data.dto.AssemblyLineDTO;
import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.service.AssemblyLineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/assembly-lines")
@SecurityRequirement(name = "authentication")
public class AssemblyLineController {

    AssemblyLineService assemblyLineService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all the Assembly Lines from data base.
            """)
    public List<AssemblyLineDTO> getAllAssemblyLines() {
        return assemblyLineService.findAll().stream().map(AssemblyLine::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Assembly Line to data base.
            """)
    public AssemblyLineDTO saveAssemblyLine(@RequestBody AssemblyLineDTO assemblyLineDTO) {
        try {
            AssemblyLine assemblyLine = assemblyLineDTO.toModel();
            return assemblyLineService.insert(assemblyLine).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update an existing Assembly Line in data base.
            """)
    public AssemblyLineDTO updateAssemblyLine(@RequestBody AssemblyLineDTO assemblyLineDTO) {
        try {
            AssemblyLine assemblyLine = assemblyLineDTO.toModel();
            return assemblyLineService.update(assemblyLine).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a Assembly Line from data base using assemblyLineId as parameter.
            """)
    public Boolean deleteAssemblyLineById(@PathVariable("id") Integer assemblyLineId) {
        return assemblyLineService.deleteById(assemblyLineId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve Assembly Line from data base using assemblyLineId as parameter.
            """)
    public AssemblyLineDTO getAssemblyLineById(@PathVariable("id") Integer assemblyLineId) {
        return assemblyLineService.findById(assemblyLineId).toDto();
    }
}
