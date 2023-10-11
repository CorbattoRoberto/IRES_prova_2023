package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.DettagliFormula;
import it.euris.academy.teslabattery_hx.data.entity.key.ChiaviDetagliFormula;

import java.util.List;

public interface DettagliFormulaService {
    List<DettagliFormula> findAll();

    DettagliFormula insert(DettagliFormula dettagliFormula);

    DettagliFormula update(DettagliFormula dettagliFormula);

    Boolean deleteById(Integer  catenaDiMontaggioId, Integer componentiId);

    DettagliFormula findById(Integer  catenaDiMontaggioId, Integer componentiId);
}
