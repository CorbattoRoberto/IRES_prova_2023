package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.ComponentRepository;
import it.euris.javaacademy.teslabattery.service.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    ComponentRepository componentRepository;

    @Override
    public List<Component> findAll() {
        return componentRepository.findAll();
    }

    @Override
    public Component insert(Component component) {
        if (component.getId() != null) {
            throw new IdMustBeNullException();
        }
        return componentRepository.save(component);
    }

    @Override
    public Component update(Component component) {
        if (component.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return componentRepository.save(component);
    }

    @Override
    public Component findById(Integer componentId) {
        return componentRepository.findById(componentId).orElse(Component.builder().build());
    }

    @Override
    public Boolean deleteById(Integer componentId) {
        componentRepository.deleteById(componentId);
        return componentRepository.findById(componentId).isEmpty();
    }
}
