package it.euris.academy.teslabattery_hx.repository;

import it.euris.academy.teslabattery_hx.data.entity.DettagliFormula;
import it.euris.academy.teslabattery_hx.data.entity.key.ChiaviDetagliFormula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DettagliFromulaRepository extends JpaRepository<DettagliFormula, ChiaviDetagliFormula> {
}
