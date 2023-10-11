package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.Supervisor;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.SupervisorRepository;
import it.euris.javaacademy.teslabattery.service.SupervisorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    SupervisorRepository supervisorRepository;

    @Override
    public List<Supervisor> findAll() {
        return supervisorRepository.findAll();
    }

    @Override
    public Supervisor insert(Supervisor supervisor) {
        if (supervisor.getId() != null) {
            throw new IdMustBeNullException();
        }
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor update(Supervisor supervisor) {
        if (supervisor.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return supervisorRepository.save(supervisor);

    }

    @Override
    public Supervisor findById(Integer supervisorId) {
        return supervisorRepository.findById(supervisorId).orElse(Supervisor.builder().build());
    }

    @Override
    public Boolean deleteById(Integer supervisorId) {
        supervisorRepository.deleteById(supervisorId);
        return supervisorRepository.findById(supervisorId).isEmpty();
    }
}
