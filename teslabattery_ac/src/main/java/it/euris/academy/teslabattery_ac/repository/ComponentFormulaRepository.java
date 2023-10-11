package it.euris.academy.teslabattery_ac.repository;

import it.euris.academy.teslabattery_ac.entity.ComponentFormula;
import org.springframework.data.jpa.repository.JpaRepository;

// La primary key dev'essere di tipo ComponentFormulaKey, non Integer
public interface ComponentFormulaRepository extends JpaRepository<ComponentFormula, Integer> {
}
