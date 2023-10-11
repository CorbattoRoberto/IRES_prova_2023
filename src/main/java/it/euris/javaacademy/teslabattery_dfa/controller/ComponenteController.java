package it.euris.javaacademy.teslabattery_dfa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery_dfa.data.dto.ComponenteDTO;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.service.ComponenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/componente")
@SecurityRequirement(name = "authentication")
public class ComponenteController {

    ComponenteService componentesService;

    @GetMapping("/v1")
    @Operation(description = """
      This method is used to retrieve all the components from the database<br>
      """)
    public List<ComponenteDTO> getAllComponents() {
        return componentesService.findAll().stream().map(Componente::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
      This method is used to insert a component in the database<br>
      """)
    public ComponenteDTO saveComponent(@RequestBody ComponenteDTO componenteDTO){
        try{
            Componente componente = componenteDTO.toModel();
            return componentesService.insert(componente).toDto();
        }
        catch(IdMustBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
      This method is used to update a component in the database<br>
      """)
    public ComponenteDTO updateComponent(@RequestBody ComponenteDTO componenteDTO){
        try{
            Componente componente = componenteDTO.toModel();
            return componentesService.update(componente).toDto();
        }
        catch(IdMustNotBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/v1/{id}")
    @Operation(description = """
      This method is used to delete a component in the database by id<br>
      """)
    public Boolean deleteComponentById(@PathVariable("id") Integer id) {
        return componentesService.deleteById(id);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
      This method is used to get a component in the database by id<br>
      """)
    public ComponenteDTO getComponentById(@PathVariable("id") Integer id) {
        return componentesService.findById(id).toDto();
    }
}
