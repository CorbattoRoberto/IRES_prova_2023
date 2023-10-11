package it.euris.javaacademy.teslabattery_dfa.repository;

import it.euris.javaacademy.teslabattery_dfa.data.entity.CicloProduttivo;
import it.euris.javaacademy.teslabattery_dfa.repository.projection.CicliCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CicloProduttivoRepository extends JpaRepository<CicloProduttivo,Integer> {

    @Query(
            value =
                    "SELECT COUNT(a.id) as countAll, "
                            + " SUM(CASE WHEN a.deleted=0 THEN 1 ELSE 0 END) as countOk, "
                            + " SUM(CASE WHEN a.deleted=1 THEN 1 ELSE 0 END) as countDeleted "
                            + "   FROM product a",
            nativeQuery = true)
    CicliCountProjection getCount();

}
