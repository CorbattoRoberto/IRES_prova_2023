package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.Supervisore;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.SupervisoreRepository;
import it.euris.academy.teslabattery_hx.service.SupervisoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisoreServiceImpl implements SupervisoreService {
    SupervisoreRepository supervisoreRepository;

    @Override
    public List<Supervisore> findAll() {
        return supervisoreRepository.findAll();
    }

    @Override
    public Supervisore insert(Supervisore supervisore) {
        if(supervisore.getId() != null && supervisore.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return supervisoreRepository.save(supervisore);
    }

    @Override
    public Supervisore update(Supervisore supervisore) {
        if(supervisore.getId() == null || supervisore.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return supervisoreRepository.save(supervisore);
    }

    @Override
    public Boolean deleteById(Integer supervisoreId) {
        supervisoreRepository.deleteById(supervisoreId);
        return supervisoreRepository.findById(supervisoreId).isEmpty();    }

    @Override
    public Supervisore findById(Integer supervisoreId) {
        return supervisoreRepository.findById(supervisoreId).orElse(Supervisore.builder().build());
    }
}
