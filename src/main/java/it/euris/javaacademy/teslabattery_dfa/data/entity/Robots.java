package it.euris.javaacademy.teslabattery_dfa.data.entity;

import it.euris.javaacademy.teslabattery_dfa.data.dto.RobotsDTO;
import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "robots")
public class Robots implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    // La relazione è corretta. Il nome del campo deve fare riferimento all'entity relazionata
    // es: catenadimontaggio_id
    // In questo caso è conveniente usare una tabela intermedia con ua chiave
    // composta catena di montaggio/robot
    @ManyToOne
    @JoinColumn(name = "robots_id")
    private CatenaDiMontaggio catenaDiMontaggio;

    @Column(name = "robotName")
    private String robotName;

    @Column(name = "position")
    private Integer position;

    @Override
    public RobotsDTO toDto() {
        return RobotsDTO.builder()
                .catenaDiMontaggio(catenaDiMontaggio)
                .robotName(robotName)
                .id(id)
                .position(position)
                .build();
    }
}


