package it.euris.javaacademy.teslabattery.service;

import it.euris.javaacademy.teslabattery.data.entity.AssemblyLine;

import java.util.List;

public interface AssemblyLineService {

    List<AssemblyLine> findAll();

    AssemblyLine insert(AssemblyLine assemblyLine);

    AssemblyLine update(AssemblyLine assemblyLine);

    AssemblyLine findById(Integer assemblyLineId);

    Boolean deleteById(Integer assemblyLineId);


}
