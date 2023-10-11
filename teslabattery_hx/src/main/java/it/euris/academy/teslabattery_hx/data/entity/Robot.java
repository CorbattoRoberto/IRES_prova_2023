package it.euris.academy.teslabattery_hx.data.entity;

import it.euris.academy.teslabattery_hx.data.dto.RobotDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import it.euris.academy.teslabattery_hx.data.enums.TipoRobot;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.numberToString;
import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.tipoRobotToString;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="robot")
public class Robot implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="catena_di_montaggio_id", nullable=false)
    private CatenaDiMontaggio catenaDiMontaggio;

    @Column(name="psozione")
    private Integer posizione;

    @Column(name="mansione")
    @Enumerated(EnumType.STRING)
    private TipoRobot mansione;

    @Column(name = "marca")
    private String marca;
    @Override
    public RobotDTO toDto() {
        return RobotDTO
                .builder()
                .id(numberToString(id))
                .catenaDiMontaggioId(numberToString(catenaDiMontaggio.getId()))
                .posizione(numberToString(posizione))
                .mansione(tipoRobotToString(mansione))
                .marca(marca)
                .build();
    }
}
