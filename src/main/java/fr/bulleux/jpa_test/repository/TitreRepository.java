package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Iot;
import fr.bulleux.jpa_test.model.Titre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitreRepository extends CrudRepository<Titre, Integer> {

    @Query(value = "select * from titre where id_titre like :#{#id}", nativeQuery = true)
    public Titre findTheTitreById(@Param("id") Integer id);

    

}
