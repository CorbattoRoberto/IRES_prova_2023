package it.euris.academy.teslabattery_ac.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.teslabattery_ac.dto.archetype.Dto;
import it.euris.academy.teslabattery_ac.dto.archetype.Model;
import it.euris.academy.teslabattery_ac.entity.ProductionCycle;
import it.euris.academy.teslabattery_ac.entity.Supervisor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupervisorDTO implements Dto {

    private Integer id;

    private Boolean lockedCycle = false;

    private Boolean inRang = true;
    @Override
    public Supervisor toModel() {
        return Supervisor
                .builder()
                .id(id)
                .inRang(inRang)
                .lockedCycle(lockedCycle)
                .build();
    }
}
