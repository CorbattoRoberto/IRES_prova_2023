package it.euris.academy.teslabattery_hx.service.impl;

import it.euris.academy.teslabattery_hx.data.entity.DettagliFormula;
import it.euris.academy.teslabattery_hx.data.entity.key.ChiaviDetagliFormula;
import it.euris.academy.teslabattery_hx.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_hx.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_hx.repository.DettagliFromulaRepository;
import it.euris.academy.teslabattery_hx.service.DettagliFormulaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DettagliFormulaServiceImpl implements DettagliFormulaService {
DettagliFromulaRepository dettagliFromulaRepository;

    @Override
    public List<DettagliFormula> findAll() {
        return dettagliFromulaRepository.findAll();
    }

    @Override
    public DettagliFormula insert(DettagliFormula dettagliFormula) {
        if(dettagliFormula.getId().getCatenaDiMontaggioId() != null) {
            throw new IdMustBeNullException();
        }
        if(dettagliFormula.getId().getComponentiId() != null) {
            throw new IdMustBeNullException();
        }
        return dettagliFromulaRepository.save(dettagliFormula);
    }

    @Override
    public DettagliFormula update(DettagliFormula dettagliFormula) {
        if(dettagliFormula.getId().getCatenaDiMontaggioId() == null) {
            throw new IdMustNotBeNullException();
        }
        if(dettagliFormula.getId().getComponentiId() == null) {
            throw new IdMustNotBeNullException();
        }
        return dettagliFromulaRepository.save(dettagliFormula);
    }

    @Override
    public Boolean deleteById(Integer catenaDiMontaggioId, Integer componentiId) {
        ChiaviDetagliFormula chiaviDetagliFormula = new ChiaviDetagliFormula(catenaDiMontaggioId, componentiId);
        dettagliFromulaRepository.deleteById(chiaviDetagliFormula);
        return dettagliFromulaRepository.findById(chiaviDetagliFormula).isEmpty();
    }

    @Override
    public DettagliFormula findById(Integer catenaDiMontaggioId, Integer componentiId) {
        ChiaviDetagliFormula chiaviDetagliFormula = new ChiaviDetagliFormula(catenaDiMontaggioId, componentiId);
        return dettagliFromulaRepository.findById(chiaviDetagliFormula).orElse(DettagliFormula.builder().build());
    }
}
