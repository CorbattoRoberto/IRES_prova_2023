package it.euris.academy.teslabattery_ac.controller;

import it.euris.academy.teslabattery_ac.dto.ComponentDTO;
import it.euris.academy.teslabattery_ac.entity.Component;
import it.euris.academy.teslabattery_ac.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_ac.service.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/components")
public class ComponentController {
    ComponentService componentService;
    @GetMapping("/v1")
    public List<ComponentDTO> getAllComponent() {
        return componentService.findAll().stream().map(Component::toDto).toList();
    }

    @PostMapping("/v1")
    public ComponentDTO saveComponent(@RequestBody ComponentDTO componentDTO) {
        try{
            Component component = componentDTO.toModel();
            return componentService.insert(component).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    public ComponentDTO updateComponent(@RequestBody ComponentDTO componentDTO) {
        Component component = componentDTO.toModel();
        return componentService.update(component).toDto();
    }



    @DeleteMapping("/v1/{id}")
    public Boolean deleteComponent(@PathVariable("id") Integer id)
    {
        return componentService.deleteById(id);
    }

}
