package it.euris.academy.teslabattery_hx.data.dto;

import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.entity.Supervisore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToBoolean;
import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupervisoreDTO implements Dto {
    private String id;
    private String cicloBloccato;
    private String parametriQualita;


    @Override
    public Supervisore toModel() {
        return Supervisore
                .builder()
                .id(stringToInteger(id))
                .cicloBloccato(stringToBoolean(cicloBloccato))
                .parametriQualita(stringToBoolean(parametriQualita))
                .build();
    }


}
