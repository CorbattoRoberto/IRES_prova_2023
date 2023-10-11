package it.euris.javaacademy.teslabattery.data.entity;


import it.euris.javaacademy.teslabattery.data.dto.FormulaComponentDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "entity_component")
public class FormulaComponent implements Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "formula_id")
    private Formula formula;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Override
    public FormulaComponentDTO toDto() {
        return FormulaComponentDTO
                .builder()
                .id(numberToString(id))
                .formulaId(numberToString(formula.getId()))
                .componentId(numberToString(component.getId()))
                .amount(numberToString(amount))
                .unitOfMeasurement(unitOfMeasurement)
                .build();
    }
}

