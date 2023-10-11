package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.entity.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentDTO implements Dto {

    private String id;
    private String name;
    private String quantity;
    private Boolean danger;

    @Override
    public Component toModel() {
        return Component
                .builder()
                .id(stringToInteger(id))
                .name(name)
                .quantity(stringToInteger(quantity))
                .danger(danger)
                .build();
    }
}
