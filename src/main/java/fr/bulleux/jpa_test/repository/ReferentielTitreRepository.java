package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.ReferentielTitre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferentielTitreRepository extends CrudRepository<ReferentielTitre, Integer> {

    @Query(value = "select * from referentiel_titre where id_rt like :#{#id}", nativeQuery = true)
    public ReferentielTitre findTheReferentielTitreById(@Param("id") Integer id);
}
