package it.euris.javaacademy.teslabattery_dfa.service.impl;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.repository.ComponenteRepository;
import it.euris.javaacademy.teslabattery_dfa.service.ComponenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ComponenteServiceImpl implements ComponenteService {

    ComponenteRepository componenteRepository;
    @Override
    public List<Componente> findAll() {
        return componenteRepository.findAll();    }

    @Override
    public Componente insert(Componente componente) {
        if(componente.getId() != null) {
            throw new IdMustBeNull();
        }
        return componenteRepository.save(componente);
    }

    @Override
    public Componente update(Componente componente) {
        if(componente.getId() == null) {
            throw new IdMustNotBeNull();
        }
        return componenteRepository.save(componente);
    }

    @Override
    public Boolean deleteById(Integer id) {
        componenteRepository.deleteById(id);
        return componenteRepository.findById(id).isEmpty();
    }


}
