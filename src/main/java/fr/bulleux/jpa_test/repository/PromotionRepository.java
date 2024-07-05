package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion, Integer> {

    @Query(value = "select * from promotion where id_promotion like :#{#id}", nativeQuery = true)
    public Promotion findThePromotionById(@Param("id") Integer id);

    

}
