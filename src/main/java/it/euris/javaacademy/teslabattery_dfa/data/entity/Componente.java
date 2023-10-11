package it.euris.javaacademy.teslabattery_dfa.data.entity;

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
public class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "component_name" , nullable = false)
    protected ComponentName componentName;

    @Column(name = "dangerous" , nullable = false)
    protected Boolean isItDangerous;
}
