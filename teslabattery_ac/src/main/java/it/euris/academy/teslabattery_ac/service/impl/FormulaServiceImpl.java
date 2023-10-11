package it.euris.academy.teslabattery_ac.service.impl;

import it.euris.academy.teslabattery_ac.entity.Formula;
import it.euris.academy.teslabattery_ac.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_ac.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_ac.repository.FormulaRepository;
import it.euris.academy.teslabattery_ac.service.FormulaService;

import java.util.List;

public class FormulaServiceImpl implements FormulaService {
    FormulaRepository formulaRepository;
    @Override
    public List<Formula> findAll() {
        return formulaRepository.findAll();
    }

    @Override
    public Formula insert(Formula formula) {
        if(formula.getId() != null) {
            throw new IdMustBeNullException();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Formula update(Formula formula) {
        if(formula.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Boolean deleteById(Integer idFormula) {
        formulaRepository.deleteById(idFormula);
        return formulaRepository.findById(idFormula).isEmpty();
    }
}
