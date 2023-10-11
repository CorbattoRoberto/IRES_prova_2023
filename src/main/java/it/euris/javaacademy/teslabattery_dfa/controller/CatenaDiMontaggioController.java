package it.euris.javaacademy.teslabattery_dfa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery_dfa.data.dto.CatenaDiMontaggioDTO;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.service.CatenaDiMontaggioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/catene")
@SecurityRequirement(name = "authentication")
public class CatenaDiMontaggioController {

    CatenaDiMontaggioService catenaDiMontaggioService;

    @GetMapping("/v1")
    @Operation(description = """
      This method is used to retrieve all the assembly lines from the database<br>
      """)
    public List<CatenaDiMontaggioDTO> getAllAssemblyLines() {
        return catenaDiMontaggioService.findAll().stream().map(CatenaDiMontaggio::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
      This method is used to insert an assembly line in the database<br>
      """)
    public CatenaDiMontaggioDTO saveAssemblyLine(@RequestBody CatenaDiMontaggioDTO catenaDiMontaggioDTO){
        try{
            CatenaDiMontaggio catenaDiMontaggio = catenaDiMontaggioDTO.toModel();
            return catenaDiMontaggioService.insert(catenaDiMontaggio).toDto();
        }
        catch(IdMustBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
      This method is used to update an assembly line in the database<br>
      """)
    public CatenaDiMontaggioDTO updateAssemblyLine(@RequestBody CatenaDiMontaggioDTO catenaDiMontaggioDTO){
        try{
            CatenaDiMontaggio catenaDiMontaggio = catenaDiMontaggioDTO.toModel();
            return catenaDiMontaggioService.update(catenaDiMontaggio).toDto();
        }
        catch(IdMustNotBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/v1/{id}")
    @Operation(description = """
      This method is used to delete an assembly line in the database by id<br>
      """)
    public Boolean deleteAssemblyLineById(@PathVariable("id") Integer id) {
        return catenaDiMontaggioService.deleteById(id);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
      This method is used to get an  assembly line in the database by id<br>
      """)
    public CatenaDiMontaggioDTO getAssemblyLineById(@PathVariable("id") Integer id) {
        return catenaDiMontaggioService.findById(id).toDto();
    }
}
