package it.euris.academy.teslabattery_ac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.ComponentDTO;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
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
@Table(name = "component")
public class Component implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name = "dangerous")
    @Builder.Default
    private Boolean dangerous = false;

    @OneToMany(mappedBy = "component", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    private List<ComponentFormula> componentFormulas = new ArrayList<>();



    @Override
    public ComponentDTO toDto() {

        return ComponentDTO
                .builder()
                .id(id)
                .dangerous(dangerous)
                .name(name)
                .build();
    }
}
