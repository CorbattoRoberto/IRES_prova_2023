package it.euris.academy.teslabattery_ac.entity;

import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.enums.StatusType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_cycle")
public class ProductionCycle implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "status_type")
    @Enumerated(EnumType.STRING)
    private StatusType statusType;

    @Column(name = "status_date")
    private LocalDateTime statusDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    // Dipendenza verso il Supervisor mancante
    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisorId;

    @Override
    public Dto toDto() {
        return null;
    }
}
