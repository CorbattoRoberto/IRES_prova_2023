package it.euris.academy.teslabattery_ac.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formula")
public class Formula {
    @EmbeddedId
    private Formula id;

    @OneToOne
    @MapsId("assemblyLineId")
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name="quantity_of_component")
    private Integer quantityOfComponent;

    @Column(name="unit_of_measure_of_quantity")
    private String unitOfMeasureOfQuantity;
}
