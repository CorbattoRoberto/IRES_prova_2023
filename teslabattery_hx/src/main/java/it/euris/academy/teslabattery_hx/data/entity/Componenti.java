package it.euris.academy.teslabattery_hx.data.entity;

import it.euris.academy.teslabattery_hx.data.dto.ComponentiDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;

import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "componenti")
public class Componenti implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="sostanze")
    private String sostanza;

    @Builder.Default
    @Column(name="pericoloso")
    private Boolean pericoloso=true;

    @Override
    public ComponentiDTO toDto() {
        return ComponentiDTO
                .builder()
                .id(numberToString(id))
                .sostanza(sostanza)
                .pericoloso(booleanToString(pericoloso))
                .build();
    }
}
