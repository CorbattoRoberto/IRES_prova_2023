package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import it.euris.javaacademy.teslabattery.data.entity.ProductionCycle;
import it.euris.javaacademy.teslabattery.data.entity.Supervisor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionCycleDTO implements Dto {


    private String id;
    private String assemblyLineId;
    private String startTime;
    private String productiveCycleStatus;
    private String statusDate;
    private String endTime;
    private String supervisorId;


    @Override
    public ProductionCycle toModel() {
        return ProductionCycle
                .builder()
                .id(stringToInteger(id))
                .assemblyLine(AssemblyLine.builder().id(stringToInteger(assemblyLineId)).build())
                .startTime(stringToLocalDateTime(startTime))
                .productiveCycleStatus(stringToProductiveCycleStatus(productiveCycleStatus))
                .statusDate(stringToLocalDateTime(statusDate))
                .endTime(stringToLocalDateTime(endTime))
                .supervisor(Supervisor.builder().id(stringToInteger(supervisorId)).build())
                .build();
    }
}
