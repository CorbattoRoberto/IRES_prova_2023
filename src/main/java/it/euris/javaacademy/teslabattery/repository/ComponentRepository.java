package it.euris.javaacademy.teslabattery.repository;

import it.euris.javaacademy.teslabattery.data.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
}
