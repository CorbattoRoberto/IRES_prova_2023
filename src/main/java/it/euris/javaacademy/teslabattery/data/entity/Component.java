package it.euris.javaacademy.teslabattery.data.entity;


import it.euris.javaacademy.teslabattery.data.dto.ComponentDTO;
import it.euris.javaacademy.teslabattery.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;


import static it.euris.javaacademy.teslabattery.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "component")
public class Component implements Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id")
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "component_name", nullable = false)
    private String name;

    @Column(name = "danger")
    @Builder.Default()
    private Boolean danger = true;

    @Override
    public ComponentDTO toDto() {
        return ComponentDTO
                .builder()
                .id(numberToString(id))
                .quantity(numberToString(quantity))
                .name(name)
                .danger(danger)
                .build();
    }
}
