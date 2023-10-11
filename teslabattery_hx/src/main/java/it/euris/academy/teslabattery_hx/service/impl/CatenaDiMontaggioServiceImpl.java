package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.CatenaDiMontaggio;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.CatenaDiMontaggioRepository;
import it.euris.academy.teslabattery_hx.service.CatenaDiMontaggioService;
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
    public CatenaDiMontaggio insert(CatenaDiMontaggio catenaDiMontaggio) {
        if(catenaDiMontaggio.getId() != null && catenaDiMontaggio.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return catenaDiMontaggioRepository.save(catenaDiMontaggio);
    }

    @Override
    public CatenaDiMontaggio update(CatenaDiMontaggio catenaDiMontaggio) {
        if(catenaDiMontaggio.getId() == null || catenaDiMontaggio.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return catenaDiMontaggioRepository.save(catenaDiMontaggio);
    }

    @Override
    public Boolean deleteById(Integer catenaDiMontaggioId) {
        catenaDiMontaggioRepository.deleteById(catenaDiMontaggioId);
        return catenaDiMontaggioRepository.findById(catenaDiMontaggioId).isEmpty();
    }

    @Override
    public CatenaDiMontaggio findById(Integer catenaDiMontaggioId) {
        return catenaDiMontaggioRepository.findById(catenaDiMontaggioId).orElse(CatenaDiMontaggio.builder().build());
    }
}
