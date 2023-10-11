package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.Robot;

import java.util.List;

public interface RobotService {

    List<Robot> findAll();

    Robot insert(Robot robot);

    Robot update(Robot robot);

    Boolean deleteById(Integer robotId);

    Robot findById(Integer robotId);
}
