package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.Formula;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.FormulaRepository;
import it.euris.javaacademy.teslabattery.service.FormulaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormulaServiceImpl implements FormulaService {


    @Autowired
    FormulaRepository formulaRepository;

    @Override
    public List<Formula> getAllFormulas() {
        return formulaRepository.findAll();
    }

    @Override
    public Formula insert(Formula formula) {
        if (formula.getId() != null) {
            throw new IdMustBeNullException();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Formula update(Formula formula) {
        if (formula.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Formula findById(Integer formulaId) {
        return formulaRepository.findById(formulaId).orElse(Formula.builder().build());
    }

    @Override
    public Boolean deleteById(Integer formulaId) {
        formulaRepository.deleteById(formulaId);
        return formulaRepository.findById(formulaId).isEmpty();
    }
}
