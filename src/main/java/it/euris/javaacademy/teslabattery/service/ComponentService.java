package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import it.euris.javaacademy.teslabattery.data.entity.Component;

import java.util.List;

public interface ComponentService {

    List<Component> getAllComponents();

    Component insert(Component component);

    Component update(Component component);

    Component findById(Integer componentId);

    Boolean deleteById(Integer componentId);
}
