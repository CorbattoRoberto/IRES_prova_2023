package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.CicloProduttivo;

import java.util.List;

public interface CicloProduttivoService {
    List<CicloProduttivo> findAll();

    CicloProduttivo insert(CicloProduttivo cicloProduttivo);

    CicloProduttivo update(CicloProduttivo cicloProduttivo);

    Boolean deleteById(Integer cicloProduttivoId);

    CicloProduttivo findById(Integer cicloProduttivoId);
}
