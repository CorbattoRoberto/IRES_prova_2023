package it.euris.javaacademy.teslabattery_dfa.service;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Robots;

import java.util.List;

public interface RobotsService {
    public List< Robots> findAll();

    Robots insert( Robots robots);

    Robots update( Robots robots);
    Robots findById(Integer id);

    Boolean deleteById(Integer id);
}
