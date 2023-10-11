package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.CicloProduttivo;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.CicloProduttivoRepository;
import it.euris.academy.teslabattery_hx.service.CicloProduttivoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CicloProduttivoServiceImpl implements CicloProduttivoService {
    CicloProduttivoRepository cicloProduttivoRepository;
    @Override
    public List<CicloProduttivo> findAll() {
        return cicloProduttivoRepository.findAll();
    }

    @Override
    public CicloProduttivo insert(CicloProduttivo cicloProduttivo) {
        if(cicloProduttivo.getId() != null && cicloProduttivo.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return cicloProduttivoRepository.save(cicloProduttivo);
    }

    @Override
    public CicloProduttivo update(CicloProduttivo cicloProduttivo) {
        if(cicloProduttivo.getId() == null || cicloProduttivo.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return cicloProduttivoRepository.save(cicloProduttivo);
    }

    @Override
    public Boolean deleteById(Integer cicloProduttivoId) {
        cicloProduttivoRepository.deleteById(cicloProduttivoId);
        return cicloProduttivoRepository.findById(cicloProduttivoId).isEmpty();    }

    @Override
    public CicloProduttivo findById(Integer cicloProduttivoId) {
        return cicloProduttivoRepository.findById(cicloProduttivoId).orElse(CicloProduttivo.builder().build());
    }
}
