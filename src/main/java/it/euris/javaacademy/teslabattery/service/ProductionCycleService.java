package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.Component;
import it.euris.javaacademy.teslabattery.data.entity.ProductionCycle;

import java.util.List;

public interface ProductionCycleService {

    List<ProductionCycle> getAll();

    ProductionCycle insert(ProductionCycle productionCycle);

    ProductionCycle update(ProductionCycle productionCycle);

    ProductionCycle findById(Integer productionCycleId);

    Boolean deleteById(Integer productionCycleId);
}
