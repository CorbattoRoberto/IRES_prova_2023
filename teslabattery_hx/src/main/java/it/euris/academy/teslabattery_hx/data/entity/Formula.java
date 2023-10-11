package it.euris.academy.teslabattery_hx.data.entity;

import it.euris.academy.teslabattery_hx.data.dto.FormulaDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Dto;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="formula")
public class Formula implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="quantita_componenti")
    private Integer quantitaComponenti;

    @Column(name="misura_quantita")
    private Integer misuraQuantita;

    @Override
    public FormulaDTO toDto() {
        return FormulaDTO
                .builder()
                .id(numberToString(id))
                .misuraQuantita(numberToString(misuraQuantita))
                .quantitaComponeti(numberToString(quantitaComponenti))
                .build();
    }
}
