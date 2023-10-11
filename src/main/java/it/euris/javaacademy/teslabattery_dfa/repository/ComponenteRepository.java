package it.euris.javaacademy.teslabattery_dfa.repository;

import it.euris.javaacademy.teslabattery_dfa.data.entity.Componente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponenteRepository extends JpaRepository<Componente, Integer> {
}
