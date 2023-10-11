package it.euris.academy.teslabattery_ac.dto;

import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.entity.Formula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormulaDTO implements Dto {

    private Integer id;
    private AssemblyLine assemblyLine;
    private Integer componentId;
    private Integer quantityOfComponent;
    private String unitOfMeasureOfQuantity;


    @Override
    public Formula toModel() {
        return Formula
                .builder()
                .id(id)
                .assemblyLine(assemblyLine)
                .unitOfMeasureOfQuantity(unitOfMeasureOfQuantity)
                .componentId(componentId)
                .build();
    }
}

