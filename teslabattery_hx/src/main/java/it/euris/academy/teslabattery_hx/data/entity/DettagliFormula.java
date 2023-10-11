package it.euris.academy.teslabattery_hx.data.entity;

import it.euris.academy.teslabattery_hx.data.dto.DetagliFormulaDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import it.euris.academy.teslabattery_hx.data.entity.key.ChiaviDetagliFormula;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dettagli_formula")
public class DettagliFormula implements Model {
    @EmbeddedId
    private ChiaviDetagliFormula id;

    @ManyToOne
    @MapsId("catenaDiMontaggio")
    @JoinColumn(name = "catena_di_montaggio_id")
    private CatenaDiMontaggio catenaDiMontaggio;

    @ManyToOne
    @MapsId("componentiId")
    @JoinColumn(name = "componenti_id")
    private Componenti componenti;

    @Column(name = "numero_componenti")
    @Builder.Default
    private Integer numeroComponenti = 0;

    @Override
    public DetagliFormulaDTO toDto() {


        return DetagliFormulaDTO
                .builder()
                .catenaDiMontaggioId(catenaDiMontaggio == null ? null : catenaDiMontaggio.getId().toString())
                .componentiId(componenti == null ? null : componenti.getId().toString())
                .numeroComponenti(numberToString(numeroComponenti))
                .build();
    }
}
