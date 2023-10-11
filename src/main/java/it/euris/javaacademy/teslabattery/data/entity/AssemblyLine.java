package it.euris.javaacademy.teslabattery.data.entity;

import it.euris.javaacademy.teslabattery.data.dto.AssemblyLineDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "assembly_line")
public class AssemblyLine implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "production_time")
    private Integer productionTime;

    @OneToMany(mappedBy = "assemblyLine", cascade = CascadeType.ALL)
    private List<Robot> robots;

    @Override
    public AssemblyLineDTO toDto() {
        return AssemblyLineDTO
                .builder()
                .id(numberToString(id))
                .name(name)
                .productionTime(numberToString(productionTime))
                .build();
    }
}
