package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.CatenaDiMontaggio;

import java.util.List;

public interface CatenaDiMontaggioService {
    List<CatenaDiMontaggio> findAll();

    CatenaDiMontaggio insert(CatenaDiMontaggio catenaDiMontaggio);

    CatenaDiMontaggio update(CatenaDiMontaggio catenaDiMontaggio);

    Boolean deleteById(Integer catenaDiMontaggioId);

    CatenaDiMontaggio findById(Integer catenaDiMontaggioId);
}
