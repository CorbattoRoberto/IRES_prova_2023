package it.euris.academy.teslabattery_ac.service;

import it.euris.academy.teslabattery_ac.entity.Formula;

import java.util.List;

public interface FormulaService {
     List<Formula> findAll();

    Formula insert(Formula formula);

    Formula update(Formula formula);

    Boolean deleteById(Integer id);
}
