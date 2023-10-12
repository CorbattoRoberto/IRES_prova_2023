package it.euris.javaacademy.teslabattery_dfa.data.entity;

import it.euris.javaacademy.teslabattery_dfa.data.dto.FormulaDTO;
import it.euris.javaacademy.teslabattery_dfa.data.dto.archetype.Model;
import it.euris.javaacademy.teslabattery_dfa.data.entity.embeddable.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formula")
public class Formula implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // Manca la relazione verso CatenaDiMontaggio

    @ElementCollection
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "formula_id"), foreignKey = @ForeignKey(name = "ingredients_fk"))
    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public FormulaDTO toDto() {
        return FormulaDTO.builder()
                .id(id)
                .ingredients(ingredients)
                .build();
    }
}
