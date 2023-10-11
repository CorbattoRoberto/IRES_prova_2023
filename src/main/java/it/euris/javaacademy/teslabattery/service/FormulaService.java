package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.data.entity.Formula;

import java.util.List;

public interface FormulaService {

    List<Formula> getAllFormulas();

    Formula insert(Formula formula);

    Formula update(Formula formula);

    Formula findById(Integer formulaId);

    Boolean deleteById(Integer formulaId);

}
