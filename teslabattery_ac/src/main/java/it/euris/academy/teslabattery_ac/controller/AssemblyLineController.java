package it.euris.academy.teslabattery_ac.controller;

import it.euris.academy.teslabattery_ac.dto.AssemblyLineDTO;
import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_ac.service.AssemblyLineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/assemblyLines")
public class AssemblyLineController {
    AssemblyLineService assemblyLineService;
    @GetMapping("/v1")
    public List<AssemblyLineDTO> getAllAssemblyLine() {
        return assemblyLineService.findAll().stream().map(AssemblyLine::toDto).toList();
    }

    @PostMapping("/v1")
    public AssemblyLineDTO saveAssemblyLine(@RequestBody AssemblyLineDTO assemblyLineDTO) {
        try{
            AssemblyLine assemblyLine = assemblyLineDTO.toModel();
            return assemblyLineService.insert(assemblyLine).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public AssemblyLineDTO updateAssemblyLine(@RequestBody AssemblyLineDTO assemblyLineDTO) {
        AssemblyLine assemblyLine = assemblyLineDTO.toModel();
        return assemblyLineService.update(assemblyLine).toDto();
    }



    @DeleteMapping("/v1/{id}")
    public Boolean deleteAssemblyLine(@PathVariable("id") Integer id)
    {
        return assemblyLineService.deleteById(id);
    }

}
