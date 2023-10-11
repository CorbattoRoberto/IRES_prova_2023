package it.euris.javaacademy.teslabattery_dfa.data.entity;

import it.euris.javaacademy.teslabattery_dfa.data.dto.CicloProduttivoDTO;
import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Model;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ciclo_produttivo")
public class CicloProduttivo implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "catena_di_montaggio", referencedColumnName = "id")
    private CatenaDiMontaggio catenaDiMontaggio;

    @Column(name = "data_inizio")
    @Builder.Default
    LocalDateTime dataInizio = LocalDateTime.now();

    @Column(name = "data_fine")
    LocalDateTime dataFine;

    @Column(name = "status")
    Status status;

    @Column(name = "data_ultimo_status")
    LocalDateTime lastStatusUpdate;

    @Column(name = "supervisor")
    String supervisor;

    @Override
    public CicloProduttivoDTO toDto() {
        return CicloProduttivoDTO.builder()
                .id(id)
                .catenaDiMontaggio(catenaDiMontaggio)
                .dataFine(dataFine)
                .dataInizio(dataInizio)
                .status(status)
                .lastStatusUpdate(lastStatusUpdate)
                .supervisor(supervisor)
                .build();
    }
}
