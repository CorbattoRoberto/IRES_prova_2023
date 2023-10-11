package it.euris.javaacademy.teslabattery.data.entity;

import it.euris.javaacademy.teslabattery.data.dto.FormulaDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "formula")
public class Formula implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formula_id")
    private Integer id;

    @Column(name = "unit_of_measurement", nullable = false)
    private String unitOfMeasurement;

    @ManyToOne
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;


    @OneToMany(mappedBy = "formula", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductionCycle> productionCycles;

    @Override
    public FormulaDTO toDto() {
        return FormulaDTO.builder()
                .id(numberToString(id))
                .unitOfMeasurement(unitOfMeasurement)
                .assemblyLineId(numberToString(assemblyLine.getId()))
                .build();
    }
}
