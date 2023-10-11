package it.euris.javaacademy.teslabattery_dfa.repository;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotsRepository extends JpaRepository<Robots, Integer> {
}
