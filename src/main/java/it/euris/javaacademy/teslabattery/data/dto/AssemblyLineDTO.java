package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssemblyLineDTO implements Dto {


    private String id;
    private String name;
    private String productionTime;

    @Override
    public AssemblyLine toModel() {
        return AssemblyLine
                .builder()
                .id(stringToInteger(id))
                .name(name)
                .productionTime(stringToInteger(productionTime))
                .build();
    }
}
