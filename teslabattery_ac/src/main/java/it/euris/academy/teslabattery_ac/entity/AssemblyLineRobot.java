package it.euris.academy.teslabattery_ac.entity;

import it.euris.academy.teslabattery_ac.dto.AssemblyLineRobotDTO;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.key.AssemblyLineRobotKey;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "production_cycle_robot")
public class AssemblyLineRobot implements Model {
    @EmbeddedId
    private AssemblyLineRobotKey id;

    @ManyToOne
    @MapsId("assemblyLineId")
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @ManyToOne
    @MapsId("robotId")
    @JoinColumn(name = "robot_id")
    private Robot robot;

    @Override
    public AssemblyLineRobotDTO toDto() {
        return AssemblyLineRobotDTO
                .builder()
                .id(id)
                .assemblyLine(assemblyLine)
                .robot(robot)
                .build();
    }
}
