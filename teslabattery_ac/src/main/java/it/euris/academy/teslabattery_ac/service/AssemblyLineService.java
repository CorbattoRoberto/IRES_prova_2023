package it.euris.academy.teslabattery_ac.service;

import it.euris.academy.teslabattery_ac.entity.AssemblyLine;
import it.euris.academy.teslabattery_ac.entity.Component;

import java.util.List;

public interface AssemblyLineService  {
    List<AssemblyLine> findAll();

    AssemblyLine insert(AssemblyLine assemblyLine);

    AssemblyLine update(AssemblyLine assemblyLine);

    Boolean deleteById(Integer idAssemblyLine);
}
