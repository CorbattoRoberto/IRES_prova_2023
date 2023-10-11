package it.euris.javaacademy.teslabattery_dfa.service;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;

import java.util.List;

public interface ComponenteService {
    public List<Componente> findAll();

    Componente insert(Componente componente);

    Componente update(Componente componente);

    Boolean deleteById(Integer id);
}
