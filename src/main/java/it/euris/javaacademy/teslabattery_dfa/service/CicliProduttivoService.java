package it.euris.javaacademy.teslabattery_dfa.service;

import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.repository.projection.CicliCountProjection;

import java.util.List;

public interface CicliProduttivoService {
    public List<CicloProduttivo> findAll();

    CicloProduttivo insert(CicloProduttivo ciclo);

    CicloProduttivo update(CicloProduttivo ciclo);
    CicloProduttivo findById(Integer id);

    Boolean deleteById(Integer id);

    CicliCountProjection getCount();
}
