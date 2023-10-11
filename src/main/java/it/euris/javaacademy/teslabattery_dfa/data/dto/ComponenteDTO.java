package it.euris.javaacademy.teslabattery_dfa.data.dto;

import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.ComponentName;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponenteDTO implements Dto {

    private Integer id;

    protected ComponentName componentName;

    protected Boolean isItDangerous;
    @Override
    public Componente toModel() {
        return Componente.builder()
                .id(id)
                .componentName(componentName)
                .isItDangerous(isItDangerous)
                .build();
    }
}
