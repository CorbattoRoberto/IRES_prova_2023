package it.euris.javaacademy.teslabattery.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery.data.dto.ComponentDTO;
import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.service.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/components")
@SecurityRequirement(name = "authentication")
public class ComponentController {

    ComponentService componentService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all  Components from data base.
            """)
    public List<ComponentDTO> getAllComponents() {
        return componentService.findAll().stream().map(Component::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Components to data base.
            """)
    public ComponentDTO saveComponent(@RequestBody ComponentDTO componentDTO) {
        try {
            Component component = componentDTO.toModel();
            return componentService.insert(component).toDto();
        } catch (IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update an existing Components in data base.
            """)
    public ComponentDTO updateComponent(@RequestBody ComponentDTO componentDTO) {
        try {
            Component component = componentDTO.toModel();
            return componentService.update(component).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
            This method is used to delete a Components from data base using componentId as parameter.
            """)
    public Boolean deleteComponentById(@PathVariable("id") Integer componentId) {
        return componentService.deleteById(componentId);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
            This method is used to retrieve Components  from data base using componentId as parameter.
            """)
    public ComponentDTO getComponentById(@PathVariable("id") Integer componentId) {
        return componentService.findById(componentId).toDto();
    }

}
