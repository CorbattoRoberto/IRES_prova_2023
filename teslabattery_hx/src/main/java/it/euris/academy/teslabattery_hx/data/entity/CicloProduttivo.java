package it.euris.academy.teslabattery_hx.data.entity;

import it.euris.academy.teslabattery_hx.data.dto.CicloProduttivoDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import it.euris.academy.teslabattery_hx.data.enums.StatoCicloProduttivo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.*;

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
    @MapsId("catenaDiMontaggioId")
    @JoinColumn(name = "catena_di_montaggio_id", nullable = false)
    private CatenaDiMontaggio catenaDiMontaggio;

    @OneToOne
    @MapsId("supervisoreId")
    @JoinColumn(name = "supervisore_id", nullable = false)
    private Supervisore supervisore;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoCicloProduttivo stato;

    @Column(name = "data_inizio")
    private LocalDateTime dataInizio;

    @Column(name = "data_stato")
    private LocalDateTime dataStato;

    @Column(name = "data_fine")
    private LocalDateTime dataFine;

    @Override
    public CicloProduttivoDTO toDto() {
        return CicloProduttivoDTO
                .builder()
                .id(numberToString(id))
                .catenaDiMontaggioId(numberToString(catenaDiMontaggio.getId()))
                .supervisoreId(numberToString(supervisore.getId()))
                .stato(statoCicloProduttivoToString(stato))
                .dataInizio(localDateTimeToString(dataInizio))
                .dataInizio(localDateTimeToString(dataStato))
                .dataFine(localDateTimeToString(dataFine))
                .build();
    }
}
