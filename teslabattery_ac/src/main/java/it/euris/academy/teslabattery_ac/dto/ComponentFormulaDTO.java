package it.euris.academy.teslabattery_ac.dto;

import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.Component;
import it.euris.academy.teslabattery_ac.entity.ComponentFormula;
import it.euris.academy.teslabattery_ac.entity.Formula;
import it.euris.academy.teslabattery_ac.entity.key.ComponentFormulaKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentFormulaDTO implements Dto {

    private ComponentFormulaKey id;


    private Component component;


    private Formula formula;
    @Override
    public ComponentFormula toModel() {
        return ComponentFormula
                .builder()
                .component(component)
                .formula(formula)
                .id(id)
                .build();
    }
}
