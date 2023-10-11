package it.euris.academy.teslabattery_ac.repository;

import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssemblyLineRepository extends JpaRepository<AssemblyLine, Integer> {
}
