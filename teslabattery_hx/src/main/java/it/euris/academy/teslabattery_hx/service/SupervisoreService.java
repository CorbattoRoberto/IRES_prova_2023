package it.euris.academy.teslabattery_hx.service;

import it.euris.academy.teslabattery_hx.data.entity.Supervisore;

import java.util.List;

public interface SupervisoreService {
    List<Supervisore> findAll();

    Supervisore insert(Supervisore supervisore);

    Supervisore update(Supervisore supervisore);

    Boolean deleteById(Integer supervisoreId);

    Supervisore findById(Integer supervisoreId);
}
