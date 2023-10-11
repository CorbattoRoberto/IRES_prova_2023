package it.euris.javaacademy.teslabattery_dfa.data.dto;

import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RobotsDTO implements Dto {

    private Integer id;

    private CatenaDiMontaggio catenaDiMontaggio;

    private String robotName;

    private Integer position;

    @Override
    public Robots toModel() {
        return Robots.builder()
                .id(id)
                .catenaDiMontaggio(catenaDiMontaggio)
                .robotName(robotName)
                .position(position)
                .build();
    }
}
