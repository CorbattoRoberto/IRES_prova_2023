package it.euris.academy.teslabattery_ac.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ComponentFormulaKey implements Serializable {
    @Column(name="component_id")
    private Integer componentId;

    @Column(name="formula_id")
    private Integer formulaId;
}
