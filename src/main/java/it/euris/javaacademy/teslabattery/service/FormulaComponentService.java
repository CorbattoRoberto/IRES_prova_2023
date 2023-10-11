package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.FormulaComponent;

import java.util.List;

public interface FormulaComponentService {


    List<FormulaComponent> findAll();

    FormulaComponent insert(FormulaComponent formulaComponent);

    FormulaComponent update(FormulaComponent formulaComponent);

    Boolean deleteById(Integer formulaComponentId);

    FormulaComponent findById(Integer formulaComponentId);


}
