package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.Robot;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.RobotRepository;
import it.euris.javaacademy.teslabattery.service.RobotService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RobotServiceImpl implements RobotService {

    @Autowired
    RobotRepository robotRepository;

    @Override
    public List<Robot> getAll() {
        return robotRepository.findAll();
    }

    @Override
    public Robot insert(Robot robot) {
        if (robot.getId() != null) {
            throw new IdMustBeNullException();
        }
        return robotRepository.save(robot);
    }

    @Override
    public Robot update(Robot robot) {
        if (robot.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return robotRepository.save(robot);
    }

    @Override
    public Robot findById(Integer robotId) {
        return robotRepository.findById(robotId).orElse(Robot.builder().build());
    }

    @Override
    public Boolean deleteById(Integer robotId) {
        robotRepository.deleteById(robotId);
        return robotRepository.findById(robotId).isEmpty();
    }
}
