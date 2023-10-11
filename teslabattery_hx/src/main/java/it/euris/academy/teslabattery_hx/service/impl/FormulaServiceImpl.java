package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.Formula;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.FormulaRepository;
import it.euris.academy.teslabattery_hx.service.FormulaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FormulaServiceImpl implements FormulaService {
    FormulaRepository formulaRepository;

    @Override
    public List<Formula> findAll() {
        return formulaRepository.findAll();
    }

    @Override
    public Formula insert(Formula formula) {
        if(formula.getId() != null && formula.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Formula update(Formula formula) {
        if(formula.getId() == null || formula.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return formulaRepository.save(formula);
    }

    @Override
    public Boolean deleteById(Integer formulaId) {
        formulaRepository.deleteById(formulaId);
        return formulaRepository.findById(formulaId).isEmpty();
    }

    @Override
    public Formula findById(Integer formulaId) {
        return formulaRepository.findById(formulaId).orElse(Formula.builder().build());
    }
}
