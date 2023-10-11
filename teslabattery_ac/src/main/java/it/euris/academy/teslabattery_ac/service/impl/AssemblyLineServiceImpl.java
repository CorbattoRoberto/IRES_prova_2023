package it.euris.academy.teslabattery_ac.service.impl;

import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_ac.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_ac.repository.AssemblyLineRepository;
import it.euris.academy.teslabattery_ac.service.AssemblyLineService;

import java.util.List;

public class AssemblyLineServiceImpl implements AssemblyLineService {
   AssemblyLineRepository assemblyLineRepository;
    @Override
    public List<AssemblyLine> findAll() {
        return assemblyLineRepository.findAll();
    }

    @Override
    public AssemblyLine insert(AssemblyLine assemblyLine) {
        if(assemblyLine.getId() != null) {
            throw new IdMustBeNullException();
        }
        return assemblyLineRepository.save(assemblyLine);
    }

    @Override
    public AssemblyLine update(AssemblyLine assemblyLine) {
        if(assemblyLine.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return assemblyLineRepository.save(assemblyLine);
    }

    @Override
    public Boolean deleteById(Integer idAssemblyLine) {
        assemblyLineRepository.deleteById(idAssemblyLine);
        return assemblyLineRepository.findById(idAssemblyLine).isEmpty();
    }
}
