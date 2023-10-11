package it.euris.javaacademy.teslabattery.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery.data.dto.ProductionCycleDTO;
import it.euris.javaacademy.teslabattery.data.entity.ProductionCycle;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.service.ProductionCycleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/production-cycles")
@SecurityRequirement(name = "authentication")
public class ProductionCycleController {

    ProductionCycleService productionCycleService;


    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all  Production-Cycle from data base.
            """)
    public List<ProductionCycleDTO> getProductionCycle() {
        return productionCycleService.findAll().stream().map(ProductionCycle::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Production-Cycle to data base.
            """)
    public ProductionCycleDTO saveProductionCycle(@RequestBody ProductionCycleDTO productionCycleDTO) {
        try {
            ProductionCycle productionCycle = productionCycleDTO.toModel();
            return productionCycleService.insert(productionCycle).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update an existing Production-Cycle in data base.
            """)
    public ProductionCycleDTO updateProductionCycle(@RequestBody ProductionCycleDTO productionCycleDTO) {
        try {
            ProductionCycle productionCycle = productionCycleDTO.toModel();
            return productionCycleService.update(productionCycle).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a Production-Cycle from data base using productionCycleId as parameter.
            """)
    public Boolean deleteProductionCycleById(@PathVariable("id") Integer productionCycleId) {
        return productionCycleService.deleteById(productionCycleId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve Production-Cycle  from data base using productionCycleId as parameter.
            """)
    public ProductionCycleDTO getProductionCycleById(@PathVariable("id") Integer productionCycleId) {
        return productionCycleService.findById(productionCycleId).toDto();
    }


}
