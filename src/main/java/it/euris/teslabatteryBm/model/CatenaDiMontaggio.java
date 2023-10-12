package it.euris.teslabatteryBm.model;

import it.euris.teslabatteryBm.dto.CatenaDiMontaggioDTO;
import it.euris.teslabatteryBm.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalTime;

import static it.euris.teslabatteryBm.utility.DataConversionUnit.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catena_di_montaggio")
@SQLDelete(sql = "UPDATE catena_di_montaggio SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class CatenaDiMontaggio implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "tempo_di_completamento")
  private LocalTime tempoDiCompletamento;

  @Column(name = "deleted")
  @Builder.Default
  private Boolean deleted = false;

  // Secondo le specifiche, dev'essere l'entity Formula che deve contenere l'id della catena di montaggio.
  @OneToOne
  @JoinColumn(name = "id_formula")
  private Formula formula;

  // Una catena di montaggio può avere più robot associati, pertanto la relazione dev'essere @OneToMany e il campo
  // una lista di robot, e la foreign eky dovrebbe essere all'intrerno di Robot
  // L'ideale comunque, seguendo l'indicazione riportata nell'obiettivo massimo della fase 1, è quello di creare una
  // tabella inermedia a chiave primaria composta tra CatenaDiMontaggio e Robot.
  @ManyToOne
  @JoinColumn(name = "id_robot")
  private Robot robot;

  @Override
  public CatenaDiMontaggioDTO toDto() {

    // Vedi considerazione fatta nella classe dto CatenaDiMontaggioDTO

    CatenaDiMontaggioDTO catenaDiMontaggioDTO = CatenaDiMontaggioDTO
        .builder()
        .id(numberToString(id))
        .nome(nome)
        .tempoDiCompletamento(localTimeToString(tempoDiCompletamento))
        .deleted(booleanToString(deleted))
        .idFormula(numberToString(formula.getId()))
        .build();

    if( robot != null) {
      catenaDiMontaggioDTO.setIdRobot(numberToString(robot.getId()));
    }

    return catenaDiMontaggioDTO;

  }
}
