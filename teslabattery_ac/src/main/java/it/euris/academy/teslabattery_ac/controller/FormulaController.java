package it.euris.academy.teslabattery_ac.controller;

import it.euris.academy.teslabattery_ac.dto.FormulaDTO;
import it.euris.academy.teslabattery_ac.entity.Formula;
import it.euris.academy.teslabattery_ac.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_ac.service.FormulaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/formulas")
@AllArgsConstructor

public class FormulaController {
    FormulaService formulaService;
    @GetMapping("/v1")
    public List<FormulaDTO> getAllFormula() {
        return formulaService.findAll().stream().map(Formula::toDto).toList();
    }

    @PostMapping("/v1")
    public FormulaDTO saveFormula(@RequestBody FormulaDTO formulaDTO) {
        try{
            Formula formula = formulaDTO.toModel();
            return formulaService.insert(formula).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public FormulaDTO updateFormula(@RequestBody FormulaDTO formulaDTO) {
        Formula formula = formulaDTO.toModel();
        return formulaService.update(formula).toDto();
    }



    @DeleteMapping("/v1/{id}")
    public Boolean deleteFormula(@PathVariable("id") Integer id)
    {
        return formulaService.deleteById(id);
    }

}
