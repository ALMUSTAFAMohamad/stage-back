package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Activite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiviteRepository extends CrudRepository<Activite, Integer> {
    @Query(value = "select * from activite where id_activite like :#{#id}", nativeQuery = true)
    public Activite findTheActiviteById(@Param("id") Integer id);

    @Query(value = "SELECT a.id_activite FROM activite a JOIN referentiel_titre rt ON rt.id_rt = a.id_rt WHERE rt.id_rt=(SELECT rt.id_rt\tFROM referentiel_titre rt JOIN titre t ON rt.id_titre = t.id_titre WHERE t.id_titre=(SELECT t.id_titre FROM titre t\tJOIN promotion p ON p.id_titre = t.id_titre\tWHERE p.id_promotion = (SELECT p.id_promotion FROM promotion p JOIN user u ON p.id_promotion = u.id_promotion WHERE u.id_user = 2)));", nativeQuery = true)
    public List<Integer> activiteList();

}
