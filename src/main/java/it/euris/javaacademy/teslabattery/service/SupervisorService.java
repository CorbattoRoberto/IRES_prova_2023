package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.Supervisor;

import java.util.List;

public interface SupervisorService {
    List<Supervisor> findAll();

    Supervisor insert(Supervisor supervisor);

    Supervisor update(Supervisor supervisor);

    Supervisor findById(Integer supervisorId);

    Boolean deleteById(Integer supervisorId);
}
