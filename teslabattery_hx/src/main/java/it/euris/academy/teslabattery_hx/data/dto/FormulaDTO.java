package it.euris.academy.teslabattery_hx.data.dto;

import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import it.euris.academy.teslabattery_hx.data.entity.Formula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaDTO implements Dto {
    private String id;
    private String quantitaComponeti;
    private String misuraQuantita;

    @Override
    public Formula toModel() {
        return Formula
                .builder()
                .id(stringToInteger(id))
                .quantitaComponenti(stringToInteger(quantitaComponeti))
                .misuraQuantita(stringToInteger(misuraQuantita))
                .build();
    }
}
