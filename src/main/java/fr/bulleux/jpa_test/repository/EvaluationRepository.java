package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Competence;
import fr.bulleux.jpa_test.model.Evaluation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {

    @Query(value = "select * from evaluation where id_evaluation like :#{#id}", nativeQuery = true)
    public Evaluation findTheEvaluationById(@Param("id") Integer id);



}
