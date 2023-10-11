package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.Componenti;

import java.util.List;

public interface ComponentiService {
    List<Componenti> findAll();

    Componenti insert(Componenti componenti);

    Componenti update(Componenti componenti);

    Boolean deleteById(Integer componentiId);

    Componenti findById(Integer componentiId);
}
