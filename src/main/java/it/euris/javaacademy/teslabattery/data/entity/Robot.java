package it.euris.javaacademy.teslabattery.data.entity;

import it.euris.javaacademy.teslabattery.data.dto.RobotDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import it.euris.javaacademy.teslabattery.data.enums.RobotTask;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;
import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.robotTaskToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "robot")
public class Robot implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "task")
    private RobotTask task;

    @Column(name = "position")
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @Override
    public RobotDTO toDto() {
        return RobotDTO
                .builder()
                .id(numberToString(id))
                .task(robotTaskToString(task))
                .position(numberToString(position))
                .assemblyLineId(numberToString(assemblyLine.getId()))
                .build();
    }
}
