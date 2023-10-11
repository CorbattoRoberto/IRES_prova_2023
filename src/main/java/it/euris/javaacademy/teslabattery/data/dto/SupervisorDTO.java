package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.entity.Supervisor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupervisorDTO implements Dto {

    private String id;
    private String name;

    @Override
    public Supervisor toModel() {
        return Supervisor
                .builder()
                .id(stringToInteger(id))
                .name(name)
                .build();
    }
}
