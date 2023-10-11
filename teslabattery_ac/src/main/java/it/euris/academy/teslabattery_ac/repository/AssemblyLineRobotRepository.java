package it.euris.academy.teslabattery_ac.repository;

import it.euris.academy.teslabattery_ac.entity.AssemblyLineRobot;
import org.springframework.data.jpa.repository.JpaRepository;


// La primary key dev'ssere di tipo AssemblyLineRobotKey, non Integer
public interface AssemblyLineRobotRepository extends JpaRepository<AssemblyLineRobot, Integer> {
}
