package it.euris.academy.teslabattery_ac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.RobotDTO;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.enums.RobotRoleType;
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
@Table(name = "robot")
public class Robot implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "robot_role_type")
    @Enumerated(EnumType.STRING)
    private RobotRoleType robotRoleType;

    @Column(name = "location")
    private Integer location;

    @Column(name = "characteristics")
    private String characteristics;
    @OneToMany(mappedBy = "robot", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    private List<AssemblyLineRobot> assemblyLineRobots = new ArrayList<>();


    @Override
    public RobotDTO toDto() {

        return RobotDTO
                .builder()
                .id(id)
                .robotRoleType(robotRoleType)
                .characteristics(characteristics)
                .location(location)
                .build();
    }
}
