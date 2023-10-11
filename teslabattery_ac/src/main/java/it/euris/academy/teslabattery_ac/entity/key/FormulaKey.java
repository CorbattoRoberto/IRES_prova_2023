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
public class FormulaKey implements Serializable {
    @Column(name="assembly_line-id")
    private Integer orderId;

    @Column(name="component_id")
    private Integer productId;
}
