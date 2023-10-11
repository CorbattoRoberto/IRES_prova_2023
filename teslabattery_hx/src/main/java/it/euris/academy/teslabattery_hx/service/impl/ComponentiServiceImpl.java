package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.Componenti;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.ComponentiRepository;
import it.euris.academy.teslabattery_hx.service.ComponentiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ComponentiServiceImpl implements ComponentiService {
    ComponentiRepository componentiRepository;

    @Override
    public List<Componenti> findAll() {
        return componentiRepository.findAll();
    }

    @Override
    public Componenti insert(Componenti componenti) {
        if(componenti.getId() != null && componenti.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return componentiRepository.save(componenti);
    }

    @Override
    public Componenti update(Componenti componenti) {
        if(componenti.getId() == null || componenti.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return componentiRepository.save(componenti);
    }

    @Override
    public Boolean deleteById(Integer componentiId) {
        componentiRepository.deleteById(componentiId);
        return componentiRepository.findById(componentiId).isEmpty();
    }

    @Override
    public Componenti findById(Integer componentiId) {
        return componentiRepository.findById(componentiId).orElse(Componenti.builder().build());
    }
}
