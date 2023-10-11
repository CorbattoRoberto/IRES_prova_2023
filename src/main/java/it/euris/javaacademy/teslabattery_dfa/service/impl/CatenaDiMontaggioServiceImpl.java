package it.euris.javaacademy.teslabattery_dfa.service.impl;

import it.euris.javaacademy.teslabattery_dfa.data.entity.CatenaDiMontaggio;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.repository.CatenaDiMontaggioRepository;
import it.euris.javaacademy.teslabattery_dfa.service.CatenaDiMontaggioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CatenaDiMontaggioServiceImpl implements CatenaDiMontaggioService {

    CatenaDiMontaggioRepository catenaDiMontaggioRepository;
    @Override
    public List<CatenaDiMontaggio> findAll() {
        return catenaDiMontaggioRepository.findAll();
    }

    @Override
    public CatenaDiMontaggio insert(CatenaDiMontaggio catena) {
        if(catena.getId() != null) {
            throw new IdMustBeNull();
        }
        return catenaDiMontaggioRepository.save(catena);
    }

    @Override
    public CatenaDiMontaggio update(CatenaDiMontaggio catena) {
        if(catena.getId() == null) {
            throw new IdMustNotBeNull();
        }
        return catenaDiMontaggioRepository.save(catena);
    }

    @Override
    public CatenaDiMontaggio findById(Integer id) {
        return catenaDiMontaggioRepository.findById(id).orElse(CatenaDiMontaggio.builder().build());
    }

    @Override
    public Boolean deleteById(Integer id) {
        catenaDiMontaggioRepository.deleteById(id);
        return catenaDiMontaggioRepository.findById(id).isEmpty();
    }


}
