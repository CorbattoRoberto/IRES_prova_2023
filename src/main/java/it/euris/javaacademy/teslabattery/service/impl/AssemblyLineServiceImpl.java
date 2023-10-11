package it.euris.javaacademy.teslabattery.service.impl;

import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;
import it.euris.javaacademy.teslabattery.exception.IdMustBeNullException;
import it.euris.javaacademy.teslabattery.exception.IdMustNotBeNullException;
import it.euris.javaacademy.teslabattery.repository.AssemblyLineRepository;
import it.euris.javaacademy.teslabattery.service.AssemblyLineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssemblyLineServiceImpl implements AssemblyLineService {


    @Autowired
    private AssemblyLineRepository assemblyLineRepository;

    @Override
    public List<AssemblyLine> getAllAssemblyLines() {
        return assemblyLineRepository.findAll();
    }

    @Override
    public AssemblyLine insert(AssemblyLine assemblyLine) {
        if (assemblyLine.getId() != null) {
            throw new IdMustBeNullException();
        }
        return assemblyLineRepository.save(assemblyLine);
    }

    @Override
    public AssemblyLine update(AssemblyLine assemblyLine) {
        if (assemblyLine.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return assemblyLineRepository.save(assemblyLine);
    }

    @Override
    public AssemblyLine findById(Integer assemblyLineId) {
        return assemblyLineRepository.findById(assemblyLineId).orElse(AssemblyLine.builder().build());
    }


    @Override
    public Boolean deleteById(Integer assemblyLineId) {

        assemblyLineRepository.deleteById(assemblyLineId);
        return assemblyLineRepository.findById(assemblyLineId).isEmpty();
    }


}
