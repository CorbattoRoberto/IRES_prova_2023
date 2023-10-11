package it.euris.academy.teslabattery_ac.entity;

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
@Table(name = "assembly_line")
public class AssemblyLine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Long duration;

    @Builder.Default
    @OneToMany(mappedBy="id", fetch = FetchType.EAGER)
    private List<Robot> robots = new ArrayList<>();

}
