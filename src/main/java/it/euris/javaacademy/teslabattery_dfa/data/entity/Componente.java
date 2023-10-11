package it.euris.javaacademy.teslabattery_dfa.data.entity;

import it.euris.javaacademy.teslabattery_dfa.data.dto.ComponenteDTO;
import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Model;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.ComponentName;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "componente")
public class Componente implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "component_name" , nullable = false)
    protected ComponentName componentName;

    @Column(name = "dangerous" , nullable = false)
    protected Boolean isItDangerous;

    @Override
    public ComponenteDTO toDto() {
        return ComponenteDTO.builder()
                .id(id)
                .componentName(componentName)
                .isItDangerous(isItDangerous)
                .build();
    }
}
