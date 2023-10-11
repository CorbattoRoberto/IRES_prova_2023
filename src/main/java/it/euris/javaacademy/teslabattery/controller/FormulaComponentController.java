package it.euris.javaacademy.teslabattery.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery.data.dto.FormulaComponentDTO;
import it.euris.javaacademy.teslabattery.data.entity.FormulaComponent;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.service.FormulaComponentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/formula-components")
@SecurityRequirement(name = "authentication")
public class FormulaComponentController {


    FormulaComponentService formulaComponentService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all Formula-Components from data base.
            """)
    public List<FormulaComponentDTO> getAllFormulaComponent() {
        return formulaComponentService.findAll().stream().map(FormulaComponent::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Formula-Components to data base.
            """)
    public FormulaComponentDTO saveFormulaComponent(@RequestBody FormulaComponentDTO formulaComponentDTO) {
        try {
            FormulaComponent formulaComponent = formulaComponentDTO.toModel();
            return formulaComponentService.insert(formulaComponent).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update an existing Formula-Components in data base.
            """)
    public FormulaComponentDTO updateComponent(@RequestBody FormulaComponentDTO formulaComponentDTO) {
        try {
            FormulaComponent formulaComponent = formulaComponentDTO.toModel();
            return formulaComponentService.update(formulaComponent).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a Formula-Components from data base using componentId as parameter.
            """)
    public Boolean deleteComponentById(@PathVariable("id") Integer formulaComponentId) {
        return formulaComponentService.deleteById(formulaComponentId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve Formula-Components  from data base using formulaComponentId as parameter.
            """)
    public FormulaComponentDTO getFormulaComponentById(@PathVariable("id") Integer formulaComponentId) {
        return formulaComponentService.findById(formulaComponentId).toDto();
    }

}
