package it.euris.javaacademy.teslabattery.data.entity;

import it.euris.javaacademy.teslabattery.data.dto.ProductionCycleDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import it.euris.javaacademy.teslabattery.data.enums.ProductiveCycleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.*;
import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "production_cycle")
public class ProductionCycle implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "assembly_line_id")
    private AssemblyLine assemblyLine;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductiveCycleStatus productiveCycleStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "status_date")
    private LocalDateTime statusDate;


    @Column(name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;


    @Override
    public ProductionCycleDTO toDto() {
        return ProductionCycleDTO
                .builder()
                .id(numberToString(id))
                .assemblyLineId(numberToString(assemblyLine.getId()))
                .startTime(localDateTimeToString(startTime))
                .productiveCycleStatus(productiveCycleStatusTaskToString(productiveCycleStatus))
                .statusDate(localDateTimeToString(statusDate))
                .endTime(localDateTimeToString(endTime))
                .supervisorId(numberToString(supervisor.getId()))
                .build();
    }
}
