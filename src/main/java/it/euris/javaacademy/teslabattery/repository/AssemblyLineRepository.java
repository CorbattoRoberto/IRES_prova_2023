package it.euris.javaacademy.teslabattery.repository;

import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssemblyLineRepository extends JpaRepository<AssemblyLine, Integer> {
}
