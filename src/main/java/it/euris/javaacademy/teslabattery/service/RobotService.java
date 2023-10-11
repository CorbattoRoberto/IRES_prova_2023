package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.ProductionCycle;
import it.euris.javaacademy.teslabattery.data.entity.Robot;

import java.util.List;

public interface RobotService {

    List<Robot> getAll();

    Robot insert(Robot robot);

    Robot update(Robot robot);

    Robot findById(Integer robotId);

    Boolean deleteById(Integer robotId);

}
