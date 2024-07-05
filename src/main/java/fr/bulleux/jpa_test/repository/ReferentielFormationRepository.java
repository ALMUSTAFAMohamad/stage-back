package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Module;
import fr.bulleux.jpa_test.model.ReferentielFormation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferentielFormationRepository extends CrudRepository<ReferentielFormation, Integer> {

    @Query(value = "select * from referentiel_formation where id_rf like :#{#id}", nativeQuery = true)
    public ReferentielFormation findTheReferentielFormationById(@Param("id") Integer id);
}
