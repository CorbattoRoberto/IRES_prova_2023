package it.euris.academy.teslabattery_hx.data.dto;

import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.entity.Robot;
import it.euris.academy.teslabattery_hx.utility.EntityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToInteger;
import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToTipoRobot;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RobotDTO implements Dto {
    private String id;
    private String catenaDiMontaggioId;
    private String posizione;
    private String mansione;
    private String marca;


    @Override
    public Robot toModel() {
        return Robot
                .builder()
                .id(stringToInteger(id))
                .catenaDiMontaggio(EntityUtils.getCatenaDiMontaggio(stringToInteger(catenaDiMontaggioId)))
                .posizione(stringToInteger(posizione))
                .mansione(stringToTipoRobot(mansione))
                .marca(marca)
                .build();
    }


}
