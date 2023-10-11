package it.euris.academy.teslabattery_ac.repository;

import it.euris.academy.teslabattery_ac.entity.ProductionCycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCycleRepository extends JpaRepository<ProductionCycle, Integer> {
}
