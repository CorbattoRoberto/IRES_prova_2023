package it.euris.academy.teslabattery_ac.repository;

import it.euris.academy.teslabattery_ac.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
}
