package it.euris.academy.teslabattery_hx.data.entity;


import it.euris.academy.teslabattery_hx.data.dto.CatenaDiMontaggioDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catena_di_montaggio")
public class CatenaDiMontaggio implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tempo_massimo")
    private LocalDateTime tempoMassimo;

    @Builder.Default
    @OneToMany(mappedBy = "catenaDiMontaggio", fetch = FetchType.EAGER)
    private List<Robot> robots = new ArrayList<>();

    @Builder.Default
    @OneToOne(mappedBy = "catenaDiMontaggio", fetch = FetchType.EAGER)
    private CicloProduttivo cicloProduttivo = new CicloProduttivo();

    @Override
    public CatenaDiMontaggioDTO toDto() {
        return CatenaDiMontaggioDTO
                .builder()
                .id(numberToString(id))
                .nome(nome)
                .tempoMassimo(localDateTimeToString(tempoMassimo))
                .build();
    }
}
