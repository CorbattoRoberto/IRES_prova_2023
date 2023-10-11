package it.euris.javaacademy.teslabattery_dfa.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "robots")
public class Robots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @MapsId("robotId")
    @JoinColumn(name = "robotId")
    private CatenaDiMontaggio catenaDiMontaggio;

    @Column(name = "robotName")
    private String robotName;

    @Column(name = "position")
    private Integer position;

}


