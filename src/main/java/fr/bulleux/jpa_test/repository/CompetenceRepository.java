package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Competence;
import fr.bulleux.jpa_test.model.Module;
import fr.bulleux.jpa_test.model.Titre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceRepository extends CrudRepository<Competence, Integer> {

    @Query(value = "select * from competence where id_competence like :#{#id}", nativeQuery = true)
    public Competence findTheCompetenceById(@Param("id") Integer id);



    @Query(value = "SELECT c.id_competence " +
            "FROM competence c " +
            "JOIN activite a ON a.id_activite = c.id_activite " +
            "WHERE a.id_activite=15", nativeQuery = true)
    public List <String>  testingCompetence();

    @Query(value = "SELECT * FROM competence ORDER by id_activite ASC", nativeQuery = true)
    List<Competence> findAllByOrderByIdActiviteAsc();



}
