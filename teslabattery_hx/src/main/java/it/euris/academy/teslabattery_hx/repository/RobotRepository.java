package it.euris.academy.teslabattery_hx.repository;

import it.euris.academy.teslabattery_hx.data.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot,Integer> {
}
