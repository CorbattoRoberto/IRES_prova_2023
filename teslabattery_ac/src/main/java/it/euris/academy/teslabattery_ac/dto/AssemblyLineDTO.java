package it.euris.academy.teslabattery_ac.dto;

import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.entity.Formula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssemblyLineDTO implements Dto {

    private Integer id;


    private Formula formula;


    private String name;


    private Long duration;
    @Override
    public AssemblyLine toModel() {
        return AssemblyLine
                .builder()
                .id(id)
                .name(name)
                .formula(formula)
                .duration(duration)
                .build();
    }
}
