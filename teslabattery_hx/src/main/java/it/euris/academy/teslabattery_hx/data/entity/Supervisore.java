package it.euris.academy.teslabattery_hx.data.entity;

import it.euris.academy.teslabattery_hx.data.dto.SupervisoreDTO;
import it.euris.academy.teslabattery_hx.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.teslabattery_hx.utility.DataConversionUtils.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supervisore")
public class Supervisore implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    @Column(name = "ciclo_bloccato")
    private boolean cicloBloccato = false;

    @Builder.Default
    @Column(name = "parametri_qualita")
    private boolean parametriQualita = true;

    @Builder.Default
    @OneToOne(mappedBy = "supervisore", fetch = FetchType.EAGER)
    private CicloProduttivo cicloProduttivo = new CicloProduttivo();

    @Override
    public SupervisoreDTO toDto() {
        return SupervisoreDTO
                .builder()
                .id(numberToString(id))
                .cicloBloccato(booleanToString(cicloBloccato))
                .parametriQualita(booleanToString(parametriQualita))
                .build();
    }
}
