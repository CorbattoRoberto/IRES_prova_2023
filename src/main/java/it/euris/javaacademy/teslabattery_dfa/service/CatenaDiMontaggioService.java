package it.euris.javaacademy.teslabattery_dfa.service;

import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;

import java.util.List;

public interface CatenaDiMontaggioService {
    public List<CatenaDiMontaggio> findAll();

    CatenaDiMontaggio insert(CatenaDiMontaggio catena);

    CatenaDiMontaggio update(CatenaDiMontaggio catena);
    CatenaDiMontaggio findById(Integer id);

    Boolean deleteById(Integer id);

}
