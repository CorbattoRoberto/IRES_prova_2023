package it.euris.javaacademy.teslabattery_dfa.service.impl;

import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustBeNull;
import it.euris.javaacademy.teslabattery_dfa.exception.IdMustNotBeNull;
import it.euris.javaacademy.teslabattery_dfa.repository.CicloProduttivoRepository;
import it.euris.javaacademy.teslabattery_dfa.repository.projection.CicliCountProjection;
import it.euris.javaacademy.teslabattery_dfa.service.CicliProduttivoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CicliProduttivoServiceImpl implements CicliProduttivoService {
   CicloProduttivoRepository cicloProduttivoRepository;
    @Override
    public List<CicloProduttivo> findAll() {
        return cicloProduttivoRepository.findAll();    }

    @Override
    public CicloProduttivo insert(CicloProduttivo ciclo) {
        if(ciclo.getId() != null) {
            throw new IdMustBeNull();
        }
        return cicloProduttivoRepository.save(ciclo);
    }

    @Override
    public CicloProduttivo update(CicloProduttivo ciclo) {
        if(ciclo.getId() == null) {
            throw new IdMustNotBeNull();
        }
        return cicloProduttivoRepository.save(ciclo);
    }

    @Override
    public CicloProduttivo findById(Integer id) {
        return cicloProduttivoRepository.findById(id).orElse(CicloProduttivo.builder().build());
    }

    @Override
    public Boolean deleteById(Integer id) {
        cicloProduttivoRepository.deleteById(id);
        return cicloProduttivoRepository.findById(id).isEmpty();
    }

    //TODO implementare ogni mentodi di ciclicountprojection

    @Override
    public List<CicliCountProjection> getCount() {
        return cicloProduttivoRepository.getCount();
    }


}
