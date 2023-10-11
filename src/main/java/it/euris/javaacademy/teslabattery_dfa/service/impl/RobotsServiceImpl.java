package it.euris.javaacademy.teslabattery_dfa.service.impl;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.repository.RobotsRepository;
import it.euris.javaacademy.teslabattery_dfa.service.RobotsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RobotsServiceImpl implements RobotsService {
    RobotsRepository robotsRepository;
    @Override
    public List<Robots> findAll() {
        return robotsRepository.findAll();    }

    @Override
    public Robots insert(Robots robots) {
        if(robots.getId() != null) {
            throw new IdMustBeNull();
        }
        return robotsRepository.save(robots);
    }

    @Override
    public Robots update(Robots robots) {
        if(robots.getId() == null) {
            throw new IdMustNotBeNull();
        }
        return robotsRepository.save(robots);
    }

    @Override
    public Boolean deleteById(Integer id) {
        robotsRepository.deleteById(id);
        return robotsRepository.findById(id).isEmpty();
    }


}
