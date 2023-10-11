package it.euris.academy.teslabattery_ac.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable

public class AssemblyLineRobotKey {
    @Column(name="assembly_line_id")
    private Integer assemblyLineId;

    @Column(name="robot_id")
    private Integer robotId;

}
