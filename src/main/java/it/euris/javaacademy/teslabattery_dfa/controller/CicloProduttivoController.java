package it.euris.javaacademy.teslabattery_dfa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.javaacademy.teslabattery_dfa.data.dto.CicloProduttivoDTO;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.Status;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.repository.projection.CicliCountProjection;
import it.euris.javaacademy.teslabattery_dfa.service.CicliProduttivoService;
import it.euris.javaacademy.teslabattery_dfa.utility.DataConversionUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/cycles")
@SecurityRequirement(name = "authentication")
public class CicloProduttivoController {

    CicliProduttivoService cicliProduttivoService;


    @GetMapping("/v1")
    @Operation(description = """
      This method is used to retrieve all the cycles from the database<br>
      """)
    public List<CicloProduttivoDTO> getAllCycles() {
        return cicliProduttivoService.findAll().stream().map(CicloProduttivo::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
      This method is used to insert a cycle in the database<br>
      """)
    public CicloProduttivoDTO saveCycle(@RequestBody CicloProduttivoDTO cicloProduttivoDTO) {
        try{
            CicloProduttivo cicloProduttivo = cicloProduttivoDTO.toModel();
            return cicliProduttivoService.insert(cicloProduttivo).toDto();
        }
        catch(IdMustBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1")
    @Operation(description = """
      This method is used to update a cycle in the database<br>
      """)
    public CicloProduttivoDTO updateCycle(@RequestBody CicloProduttivoDTO cicloProduttivoDTO){
        try{
            CicloProduttivo cicloProduttivo = cicloProduttivoDTO.toModel();
            return cicliProduttivoService.update(cicloProduttivo).toDto();
        }
        catch(IdMustNotBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/v1/{id}-{status}")
    @Operation(description = """
      This method is used to update the status of a cycle by id<br>
      """)
    public CicloProduttivoDTO updateCycleStatusById(@PathVariable("id") Integer id, @PathVariable("status") String status) {
        try{
            // Questa parte è meglio mettrla tutta nel service, creando un metodo apposito
            // es: updateCycleStatus
            CicloProduttivo updatedCycle = cicliProduttivoService.findById(id);
            updatedCycle.setStatus(DataConversionUtils.stringToStatus(status));
            updatedCycle.setLastStatusUpdate(LocalDateTime.now());

            // Con l'aggiunta di questo controllo puoi anche verificare se lo stato del ciclo produttivo
            // è terminato, per poter gestire anche la data di fine ciclo
            if(updatedCycle.getStatus().equals(Status.COMPLETATO) ||
                updatedCycle.getStatus().equals(Status.FALLITO)) {
                updatedCycle.setDataFine(LocalDateTime.now());
            }

            return cicliProduttivoService.update(updatedCycle).toDto();
        }
        catch(IdMustNotBeNull e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/v1/{id}")
    @Operation(description = """
      This method is used to delete a cycle in the database by id<br>
      """)
    public Boolean deleteCycleById(@PathVariable("id") Integer id) {
        return cicliProduttivoService.deleteById(id);
    }

    @GetMapping("/v1/{id}")
    @Operation(description = """
      This method is used to get a cycle in the database by id<br>
      """)
    public CicloProduttivoDTO getCycleById(@PathVariable("id") Integer id) {
        return cicliProduttivoService.findById(id).toDto();
    }

    // Gli endpoint sono stati modificati a scopo dimostrativo per poter gestire correttamente le
    // statistiche suddivise per mese. I tipi di ritorno sono diventati liste di CicliCountProjection
    // mentre la percentuale viene calcolata sommando tutti i dati che sono raggruppati mese per mese

    @GetMapping("/v1/count")
    public List<CicliCountProjection> getCount() {
        return cicliProduttivoService.getCount();
    }

    @GetMapping("/v1/countPercentage")
    public String getCountPercentage() {

        Long numCountAll =
            cicliProduttivoService.getCount().stream().map(CicliCountProjection::getCountAll)
                .mapToLong(Long::longValue).sum();

        Integer numCompletati =
            cicliProduttivoService.getCount().stream().map(CicliCountProjection::getCompletati)
                .mapToInt(Integer::intValue).sum();

        double n = (double) numCompletati / numCountAll;
        return String.format("%.00f", n*100)+"%";
    }

}
