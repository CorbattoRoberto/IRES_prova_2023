package it.euris.academy.teslabattery_ac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.AssemblyLineDTO;
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
@Table(name = "assembly_line")
public class AssemblyLine implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;


    // Relazione errata, il campo è stato definito come @ManyToOne (ciò impedisce la creazione della
    // tabella) e la definizione del campo "formula_id" forma una foreign key non richiesta nelle
    // specifiche.

//    @ManyToOne
//    @JoinColumn(name="formula_id", nullable=false)
//    private Formula formula;

    // Questa è l'indicazione corretta della dipendenza
    @OneToOne(mappedBy="assemblyLine")
    private Formula formula;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Long duration;

    @OneToMany(mappedBy = "assemblyLine", fetch = FetchType.EAGER)
    @JsonIgnore
    @Builder.Default
    private List<AssemblyLineRobot> assemblyLineRobots= new ArrayList<>();



    @Override
    public AssemblyLineDTO toDto() {

        return AssemblyLineDTO
                .builder()
                .id(id)
                .duration(duration)
                .formula(formula)
                .name(name)
                .build();
    }
}
