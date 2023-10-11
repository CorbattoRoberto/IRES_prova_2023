package it.euris.academy.teslabattery_hx.data.dto;


import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import it.euris.academy.teslabattery_hx.data.entity.CatenaDiMontaggio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToInteger;
import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToLocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatenaDiMontaggioDTO implements Dto {
    private String id;
    private String nome;
    private String tempoMassimo;


    @Override
    public CatenaDiMontaggio toModel() {
        return CatenaDiMontaggio
                .builder()
                .id(stringToInteger(id))
                .nome(nome)
                .tempoMassimo(stringToLocalDateTime(tempoMassimo))
                .build();

    }
}
