package it.euris.javaacademy.teslabattery.repository;

import it.euris.javaacademy.teslabattery.data.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
}
