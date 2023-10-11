package it.euris.javaacademy.teslabattery_dfa.data.dto;

import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatenaDiMontaggioDTO implements Dto {

    private Integer id;
    public Integer completionTimeInSeconds;

    protected List<Robots> robots = new ArrayList<>();
    @Override
    public CatenaDiMontaggio toModel() {
        return CatenaDiMontaggio.builder()
                .id(id)
                .robots(robots)
                .completionTimeInSeconds(completionTimeInSeconds)
                .build();
    }
}
