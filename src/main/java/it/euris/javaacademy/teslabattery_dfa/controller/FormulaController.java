package it.euris.javaacademy.teslabattery_dfa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery_dfa.data.dto.FormulaDTO;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Formula;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.service.FormulaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/formula")
@SecurityRequirement(name = "authentication")
public class FormulaController {

    FormulaService formulaService;

    @GetMapping("/v1")
    @Operation(description = """
      This method is used to retrieve all the formulas from the database<br>
      """)
    public List<FormulaDTO> getAllFormula() {
        return formulaService.findAll().stream().map(Formula::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
      This method is used to insert a formula in the database<br>
      """)
    public FormulaDTO saveFormula(@RequestBody FormulaDTO formulaDTO){
        try{
            Formula formula = formulaDTO.toModel();
            return formulaService.insert(formula).toDto();
        }
        catch(IdMustBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
      This method is used to update a formula in the database<br>
      """)
    public FormulaDTO updateFormula(@RequestBody FormulaDTO formulaDTO){
        try{
            Formula formula = formulaDTO.toModel();
            return formulaService.update(formula).toDto();
        }
        catch(IdMustNotBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/v1/{id}")
    @Operation(description = """
      This method is used to delete a formula in the database by id<br>
      """)
    public Boolean deleteFormulaById(@PathVariable("id") Integer id) {
        return formulaService.deleteById(id);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
      This method is used to get a formula in the database by id<br>
      """)
    public FormulaDTO getFormulaById(@PathVariable("id") Integer id) {
        return formulaService.findById(id).toDto();
    }
}
