package it.euris.academy.teslabattery_ac.service.impl;

import it.euris.academy.teslabattery_ac.entity.Component;
import it.euris.academy.teslabattery_ac.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_ac.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_ac.repository.ComponentRepository;
import it.euris.academy.teslabattery_ac.service.ComponentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ComponentServiceImpl implements ComponentService {
   ComponentRepository componentRepository;
    @Override
    public List<Component> findAll() {
        return componentRepository.findAll();
    }

    @Override
    public Component insert(Component component) {
        if(component.getId() != null) {
        throw new IdMustBeNullException();
    }
        return componentRepository.save(component);
    }

    @Override
    public Component update(Component component) {
        if(component.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return componentRepository.save(component);
    }

    @Override
    public Boolean deleteById(Integer idComponent) {
        componentRepository.deleteById(idComponent);
        return componentRepository.findById(idComponent).isEmpty();
    }
}
