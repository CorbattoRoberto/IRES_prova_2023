package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.ProductionCycle;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.ProductionCycleRepository;
import it.euris.javaacademy.teslabattery.service.ProductionCycleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductionCycleServiceImpl implements ProductionCycleService {

    @Autowired
    ProductionCycleRepository productionCycleRepository;

    @Override
    public List<ProductionCycle> getAll() {
        return productionCycleRepository.findAll();
    }

    @Override
    public ProductionCycle insert(ProductionCycle productionCycle) {
        if (productionCycle.getId() != null) {
            throw new IdMustBeNullException();
        }
        return productionCycleRepository.save(productionCycle);
    }

    @Override
    public ProductionCycle update(ProductionCycle productionCycle) {
        if (productionCycle.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return productionCycleRepository.save(productionCycle);
    }

    @Override
    public ProductionCycle findById(Integer productionCycleId) {
        return productionCycleRepository.findById(productionCycleId).orElse(ProductionCycle.builder().build());
    }

    @Override
    public Boolean deleteById(Integer productionCycleId) {
        productionCycleRepository.deleteById(productionCycleId);
        return productionCycleRepository.findById(productionCycleId).isEmpty();
    }
}
