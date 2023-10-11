package it.euris.javaacademy.teslabattery_dfa.data.dto;

import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CicloProduttivoDTO implements Dto {
    private Integer id;

    private CatenaDiMontaggio catenaDiMontaggio;

    LocalDateTime dataInizio = LocalDateTime.now();

    LocalDateTime dataFine;

    Status status;

    LocalDateTime lastStatusUpdate;

    String supervisor;
    @Override
    public CicloProduttivo toModel() {
        return CicloProduttivo.builder()
                .id(id)
                .catenaDiMontaggio(catenaDiMontaggio)
                .dataInizio(dataInizio)
                .dataFine(dataFine)
                .status(status)
                .supervisor(supervisor)
                .build();
    }
}
