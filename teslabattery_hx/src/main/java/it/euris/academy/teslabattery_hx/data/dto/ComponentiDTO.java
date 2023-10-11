package it.euris.academy.teslabattery_hx.data.dto;

import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.entity.Componenti;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentiDTO implements Dto {
    private String id;
    private String pericoloso;
    private String sostanza;

    @Override
    public Componenti toModel() {
        return Componenti
                .builder()
                .id(stringToInteger(id))
                .sostanza(sostanza)
                .pericoloso(stringToBoolean(pericoloso))
                .build();
    }
}
