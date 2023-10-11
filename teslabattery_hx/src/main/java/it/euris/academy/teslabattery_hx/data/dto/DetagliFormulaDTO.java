package it.euris.academy.teslabattery_hx.data.dto;

import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import it.euris.academy.teslabattery_hx.data.entity.DettagliFormula;
import it.euris.academy.teslabattery_hx.data.entity.key.ChiaviDetagliFormula;
import it.euris.academy.teslabattery_hx.utility.EntityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.text.html.parser.Entity;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.stringToInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetagliFormulaDTO implements Dto {

    private String catenaDiMontaggioId;
    private String componentiId;
    private String numeroComponenti;

    @Override
    public DettagliFormula toModel() {
        return DettagliFormula
                .builder()
                .id(new ChiaviDetagliFormula(stringToInteger(catenaDiMontaggioId),stringToInteger(componentiId)))
                .catenaDiMontaggio(EntityUtils.getCatenaDiMontaggio(stringToInteger(catenaDiMontaggioId)))
                .componenti(EntityUtils.getComponenti(stringToInteger(componentiId)))
                .numeroComponenti(stringToInteger(numeroComponenti))
                .build();
    }
}
