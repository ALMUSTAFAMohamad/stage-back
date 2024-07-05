package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Structure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface StructureRepository extends CrudRepository<Structure, Integer> {


    @Query(value = "select * from structure where id_structure like :#{#id}", nativeQuery = true)
    public Structure findTheStructureById(@Param("id") Integer id);

}
