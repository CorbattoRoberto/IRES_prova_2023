package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import it.euris.javaacademy.teslabattery.data.entity.Formula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaDTO implements Dto {


    private String id;
    private String unitOfMeasurement;
    private String assemblyLineId;


    @Override
    public Formula toModel() {
        return Formula
                .builder()
                .id(stringToInteger(id))
                .unitOfMeasurement(unitOfMeasurement)
                .assemblyLine(AssemblyLine.builder().id(stringToInteger(assemblyLineId)).build())
                .build();
    }
}
