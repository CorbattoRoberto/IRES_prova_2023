package it.euris.javaacademy.teslabattery_dfa.data.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.javaacademy.teslabattery_dfa.data.dto.CatenaDiMontaggioDTO;
import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Model;
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
@Table(name = "catena_di_montaggio")
public class CatenaDiMontaggio implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "completion_time" , nullable = false)
    public Integer completionTimeInSeconds;

    @OneToMany(mappedBy = "catenaDiMontaggio", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    protected List<Robots> robots = new ArrayList<>();

    @Override
    public CatenaDiMontaggioDTO toDto() {
        return CatenaDiMontaggioDTO.builder()
                .id(id)
                .completionTimeInSeconds(completionTimeInSeconds)
                .robots(robots)
                .build();
    }
}
