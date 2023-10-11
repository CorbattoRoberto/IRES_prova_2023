package it.euris.academy.teslabattery_ac.entity;

import it.euris.academy.teslabattery_ac.dto.ComponentFormulaDTO;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.key.ComponentFormulaKey;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "component_formula")
public class ComponentFormula implements Model {
    @EmbeddedId
    private ComponentFormulaKey id;

    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "component_id")
    private Component component;

    @ManyToOne
    @MapsId("formulaId")
    @JoinColumn(name = "formula_id")
    private Formula formula;


    @Override
    public ComponentFormulaDTO toDto() {
        return ComponentFormulaDTO
                .builder()
                .component(component)
                .formula(formula)
                .id(id)
                .build();
    }
}
