package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.FormulaComponent;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.FormulaComponentRepository;
import it.euris.javaacademy.teslabattery.service.FormulaComponentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormulaComponentServiceImpl implements FormulaComponentService {

    @Autowired
    FormulaComponentRepository formulaComponentRepository;

    @Override
    public List<FormulaComponent> findAll() {
        return formulaComponentRepository.findAll();
    }

    @Override
    public FormulaComponent insert(FormulaComponent formulaComponent) {
        if (formulaComponent.getId() != null) {
            throw new IdMustBeNullException();
        }
        return formulaComponentRepository.save(formulaComponent);
    }

    @Override
    public FormulaComponent update(FormulaComponent formulaComponent) {
        if (formulaComponent.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return formulaComponentRepository.save(formulaComponent);
    }


    @Override
    public Boolean deleteById(Integer formulaComponentId) {
        formulaComponentRepository.deleteById(formulaComponentId);
        return formulaComponentRepository.findById(formulaComponentId).isEmpty();
    }

    @Override
    public FormulaComponent findById(Integer formulaComponentId) {
        return formulaComponentRepository.findById(formulaComponentId).orElse(FormulaComponent.builder().build());
    }
}
