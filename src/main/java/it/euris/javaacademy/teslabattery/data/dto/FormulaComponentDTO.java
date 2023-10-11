package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.data.entity.Formula;
import it.euris.javaacademy.teslabattery.data.entity.FormulaComponent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;
import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormulaComponentDTO implements Dto {

    private String id;
    private String formulaId;
    private String componentId;
    private String amount;
    private String unitOfMeasurement;

    @Override
    public FormulaComponent toModel() {
        return FormulaComponent
                .builder()
                .id(stringToInteger(id))
                .formula(Formula.builder().id(stringToInteger(formulaId)).build())
                .component(Component.builder().id(stringToInteger(componentId)).build())
                .amount(stringToInteger(amount))
                .unitOfMeasurement(unitOfMeasurement)
                .build();
    }
}
