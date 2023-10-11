package it.euris.javaacademy.teslabattery.repository;

import it.euris.javaacademy.teslabattery.data.entity.ProductionCycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCycleRepository extends JpaRepository<ProductionCycle, Integer> {
}
