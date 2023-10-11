package it.euris.academy.teslabattery_hx.data.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ChiaviDetagliFormula implements Serializable {

    @Column(name="catena_di_montaggio_id")
    private Integer catenaDiMontaggioId;

    @Column (name="componenti_id")
    private Integer componentiId;


}
