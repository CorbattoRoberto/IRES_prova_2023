package it.euris.javaacademy.teslabattery_dfa.repository;

import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.repository.projection.CicliCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CicloProduttivoRepository extends JpaRepository<CicloProduttivo,Integer> {

    // Al posto di "COMPLETATO" e "FALLITO" sono stati messi gl iordinali dell'enum
    @Query(
            value =
                    " SELECT COUNT(a.id) as countAll," +
                        " SUM(CASE WHEN a.status=5 THEN 1 ELSE 0 END) as completati, \n" +
                        " SUM(CASE WHEN a.status=6 THEN 1 ELSE 0 END) as falliti, \n" +
                        " MONTH(a.data_fine) AS mese" +
                        " FROM ciclo_produttivo a" +
                        " GROUP BY MONTH(a.data_fine)" +
                        " ORDER BY MONTH(a.data_fine)",
            nativeQuery = true)
    List<CicliCountProjection> getCount();

}
