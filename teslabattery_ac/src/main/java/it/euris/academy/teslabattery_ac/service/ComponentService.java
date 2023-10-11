package it.euris.academy.teslabattery_ac.service;

import it.euris.academy.teslabattery_ac.entity.Component;
import it.euris.academy.teslabattery_ac.entity.Formula;

import java.util.List;

public interface ComponentService {
    List<Component> findAll();

    Component insert(Component component);

    Component update(Component component);

    Boolean deleteById(Integer idComponent);
}
