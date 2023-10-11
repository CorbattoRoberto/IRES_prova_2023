package it.euris.academy.teslabattery_ac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Supervisor")
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    private List<ProductionCycle> productionCycles = new ArrayList<>();

    @Builder.Default
    @Column(name = "locked_cycle")
    private Boolean lockedCycle = false;

    @Builder.Default
    @Column(name = "in_range")
    private Boolean inRang = true;

}
