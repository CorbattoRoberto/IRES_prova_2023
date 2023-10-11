package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.Robot;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.RobotRepository;
import it.euris.academy.teslabattery_hx.service.RobotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RobotServiceImpl implements RobotService {

    RobotRepository robotRepository;
    @Override
    public List<Robot> findAll() {
        return robotRepository.findAll();
    }

    @Override
    public Robot insert(Robot robot) {
        if(robot.getId() != null && robot.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return robotRepository.save(robot);
    }

    @Override
    public Robot update(Robot robot) {
        if(robot.getId() == null || robot.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return robotRepository.save(robot);
    }

    @Override
    public Boolean deleteById(Integer robotId) {
        robotRepository.deleteById(robotId);
        return robotRepository.findById(robotId).isEmpty();
    }

    @Override
    public Robot findById(Integer robotId) {
        return robotRepository.findById(robotId).orElse(Robot.builder().build());
    }
}
