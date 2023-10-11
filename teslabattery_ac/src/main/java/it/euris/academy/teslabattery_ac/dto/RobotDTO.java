package it.euris.academy.teslabattery_ac.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.AssemblyLineRobot;
import it.euris.academy.teslabattery_ac.entity.Robot;
import it.euris.academy.teslabattery_ac.enums.RobotRoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RobotDTO implements Dto {

    private Integer id;

    private RobotRoleType robotRoleType;

    private Integer location;

    private String characteristics;

    @Override
    public Robot toModel() {
        return Robot
                .builder()
                .id(id)
                .robotRoleType(robotRoleType)
                .characteristics(characteristics)
                .location(location)
                .build();
    }
}
