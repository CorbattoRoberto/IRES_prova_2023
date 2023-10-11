package it.euris.academy.teslabattery_ac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.FormulaDTO;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formula")
public class Formula implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @MapsId("assemblyLineId")
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @OneToMany(mappedBy = "formula")
    @JsonIgnore
    @Builder.Default
    private List<ComponentFormula> componentFormulas= new ArrayList<>();


    @Column(name="component_id")
    private Integer componentId;

    @Column(name="quantity_of_component")
    private Integer quantityOfComponent;


    @Column(name="unit_of_measure_of_quantity")
    private String unitOfMeasureOfQuantity;



    @Override
    public FormulaDTO toDto() {

        return FormulaDTO
                .builder()
                .assemblyLine(assemblyLine)
                .componentId(componentId)
                .unitOfMeasureOfQuantity(unitOfMeasureOfQuantity)
                .build();
    }
}
