package it.euris.academy.teslabattery_ac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.SupervisorDTO;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
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
public class Supervisor implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "id")
    @JsonIgnore
    @Builder.Default
    private List<ProductionCycle> productionCycles = new ArrayList<>();

    @Builder.Default
    @Column(name = "locked_cycle")
    private Boolean lockedCycle = false;

    @Builder.Default
    @Column(name = "in_range")
    private Boolean inRang = true;

    @Override
    public SupervisorDTO toDto() {
        return SupervisorDTO
                .builder()
                .id(id)
                .inRang(inRang)
                .lockedCycle(lockedCycle)
                .build();
    }
}
