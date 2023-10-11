package it.euris.academy.teslabattery_ac.dto;

import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.entity.AssemblyLineRobot;
import it.euris.academy.teslabattery_ac.entity.Robot;
import it.euris.academy.teslabattery_ac.entity.key.AssemblyLineRobotKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssemblyLineRobotDTO implements Dto {

    private AssemblyLineRobotKey id;


    private AssemblyLine assemblyLine;
    private Robot robot;
    @Override
    public AssemblyLineRobot toModel() {
        return AssemblyLineRobot.builder()
                .id(id)
                .assemblyLine(assemblyLine)
                .robot(robot)
                .build();
    }
}
