package it.euris.javaacademy.teslabattery.repository;

import it.euris.javaacademy.teslabattery.data.entity.Formula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormulaRepository extends JpaRepository<Formula, Integer> {
}
