package it.euris.academy.teslabattery_ac.entity;

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
public class ProductionCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @Column(name = "start_date")
    private LocalDateTime StartDate;

    @Column(name = "status_type")
    @Enumerated(EnumType.STRING)
    private StatusType statusType;

    @Column(name = "status_date")
    private LocalDateTime statusDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

}
