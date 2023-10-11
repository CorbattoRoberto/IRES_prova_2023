package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.Formula;


import java.util.List;

public interface FormulaService {
    List<Formula> findAll();

    Formula insert(Formula formula);

    Formula update(Formula formula);

    Boolean deleteById(Integer formulaId);

    Formula findById(Integer formulaId);
}
