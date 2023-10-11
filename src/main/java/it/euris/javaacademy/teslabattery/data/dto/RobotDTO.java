package it.euris.javaacademy.teslabattery.data.dto;

import it.euris.javaacademy.teslabattery.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import it.euris.javaacademy.teslabattery.data.entity.Robot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToInteger;
import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.stringToRobotTask;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RobotDTO implements Dto {

    private String id;
    private String task;
    private String position;
    private String assemblyLineId;

    @Override
    public Robot toModel() {
        return Robot
                .builder()
                .id(stringToInteger(id))
                .task(stringToRobotTask(task))
                .position(stringToInteger(position))
                .assemblyLine(AssemblyLine.builder().id(stringToInteger(assemblyLineId)).build())
                .build();
    }
}
