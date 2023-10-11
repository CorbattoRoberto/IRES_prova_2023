package it.euris.javaacademy.teslabattery_dfa.data.dto;

import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Dto;
import it.euris.javaacademy.teslabattery_dfa.data.entity.Formula;
import it.euris.javaacademy.teslabattery_dfa.data.entity.embeddable.Ingredient;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormulaDTO implements Dto {

    private Integer id;
    private List<Ingredient> ingredients;
    @Override
    public Formula toModel() {
        return Formula.builder()
                .id(id)
                .ingredients(ingredients)
                .build();
    }
}
