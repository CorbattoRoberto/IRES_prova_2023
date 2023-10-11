package it.euris.javaacademy.teslabattery_dfa.data.entity.embeddable;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Embeddable
public class Ingredient {

    @OneToOne
    @JoinColumn(name = "componente_id")
    private Componente componente;

    private String unitadiMisura;

    private Integer quantity;

}
