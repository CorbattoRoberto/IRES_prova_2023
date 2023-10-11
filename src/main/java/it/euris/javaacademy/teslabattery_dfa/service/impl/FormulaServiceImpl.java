package it.euris.javaacademy.teslabattery_dfa.service.impl;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Formula;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.repository.FormulaRepository;
import it.euris.javaacademy.teslabattery_dfa.service.FormulaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FormulaServiceImpl implements FormulaService {

    FormulaRepository formulaRepository;
    @Override
    public List<Formula> findAll() {
        return formulaRepository.findAll();    }

    @Override
    public Formula insert(Formula formula) {
        if(formula.getId() != null) {
            throw new IdMustBeNull();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Formula update(Formula formula) {
        if(formula.getId() == null) {
            throw new IdMustNotBeNull();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Formula findById(Integer id) {
        return formulaRepository.findById(id).orElse(Formula.builder().build());
    }

    @Override
    public Boolean deleteById(Integer id) {
        formulaRepository.deleteById(id);
        return formulaRepository.findById(id).isEmpty();
    }

}
