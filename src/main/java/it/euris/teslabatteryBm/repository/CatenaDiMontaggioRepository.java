package it.euris.teslabatteryBm.repository;

import it.euris.teslabatteryBm.model.CatenaDiMontaggio;
import org.springframework.data.jpa.repository.JpaRepository;

// Le specifiche riportano che devono essere implementati tutti i repository delle entity gestite dall'applicativo

public interface CatenaDiMontaggioRepository extends JpaRepository<CatenaDiMontaggio,Long> {
}
