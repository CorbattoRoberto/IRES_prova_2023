package it.euris.teslabatteryBm.dto;

import it.euris.teslabatteryBm.dto.archetype.Dto;
import it.euris.teslabatteryBm.dto.archetype.Model;
import it.euris.teslabatteryBm.model.CatenaDiMontaggio;
import it.euris.teslabatteryBm.model.Formula;
import it.euris.teslabatteryBm.model.Robot;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

import static it.euris.teslabatteryBm.utility.DataConversionUnit.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatenaDiMontaggioDTO implements Dto {
  private String id;

  private String nome;

  private String tempoDiCompletamento;

  private String deleted;

  private String idFormula;

  private String idRobot;

  @Override
  public CatenaDiMontaggio toModel() {

    // Visto che è stata inserita la relazione del robot in questa classe, conviene verificare che il campo sia
    // vlaorizzato, peima di inserirlo nel model, altrimenti per come è impostato il codice qui si è obbligati ad
    // inserire prima almeno una registrazione nella tabella Robot

    CatenaDiMontaggio catenaDiMontaggio =CatenaDiMontaggio
        .builder()
        .id(stringToLong(id))
        .nome(nome)
        .tempoDiCompletamento(stringToLocalTime(tempoDiCompletamento))
        .formula(Formula.builder().id(stringToLong(idFormula)).build())
        .deleted(stringToBoolean(deleted))
        .build();

    if( idRobot != null) {
      catenaDiMontaggio.setRobot(Robot.builder().id(stringToLong(idRobot)).build());
    }

    return catenaDiMontaggio;

  }
}
