package it.euris.javaacademy.teslabattery.data.entity;

import it.euris.javaacademy.teslabattery.data.dto.SupervisorDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "supervisor")
public class Supervisor implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Override
    public SupervisorDTO toDto() {
        return SupervisorDTO
                .builder()
                .id(numberToString(id))
                .name(name)
                .build();
    }
}
