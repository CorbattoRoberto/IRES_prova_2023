package it.euris.academy.teslabattery_hx.data.dto;

import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.entity.CicloProduttivo;
import it.euris.academy.teslabattery_hx.utility.EntityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CicloProduttivoDTO implements Dto {
    private String id;
    private String catenaDiMontaggioId;
    private String supervisoreId;
    private String stato;
    private String dataInizio;
    private String dataStatus;
    private String dataFine;

    @Override
    public CicloProduttivo toModel() {
        return CicloProduttivo
                .builder()
                .id(stringToInteger(id))
                .catenaDiMontaggio(EntityUtils.getCatenaDiMontaggio(stringToInteger(catenaDiMontaggioId)))
                .supervisore(EntityUtils.getSuperVisore(stringToInteger(supervisoreId)))
                .stato(stringToStatoCicloProduttivo(stato))
                .dataInizio(stringToLocalDateTime(dataInizio))
                .dataStato(stringToLocalDateTime(dataStatus))
                .dataFine(stringToLocalDateTime(dataFine))
                .build();

    }
}
