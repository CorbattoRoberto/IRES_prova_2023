package it.euris.javaacademy.teslabattery_dfa.service;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Formula;

import java.util.List;

public interface FormulaService {

    public List<Formula> findAll();

    Formula insert(Formula formula);

    Formula update(Formula formula);
    Formula findById(Integer id);

    Boolean deleteById(Integer id);

}
