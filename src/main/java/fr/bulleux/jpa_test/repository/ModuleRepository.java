package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {

    @Query(value = "select * from module where id_module like :#{#id}", nativeQuery = true)
    public Module findTheModuleById(@Param("id") Integer id);

}
