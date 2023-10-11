package it.euris.academy.teslabattery_ac.repository;

import it.euris.academy.teslabattery_ac.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot, Integer> {
}
