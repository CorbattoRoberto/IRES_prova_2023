package it.euris.academy.teslabattery_ac.dto;

import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.entity.ProductionCycle;
import it.euris.academy.teslabattery_ac.enums.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCycleDTO implements Dto {

    private Integer id;


    private AssemblyLine assemblyLine;


    private LocalDateTime startDate;


    private StatusType statusType;

    private LocalDateTime statusDate;


    private LocalDateTime endDate;
    @Override
    public ProductionCycle toModel() {
        return ProductionCycle
                .builder()
                .assemblyLine(assemblyLine)
                .endDate(endDate)
                .id(id)
                .startDate(startDate)
                .statusDate(statusDate)
                .build();
    }
}
