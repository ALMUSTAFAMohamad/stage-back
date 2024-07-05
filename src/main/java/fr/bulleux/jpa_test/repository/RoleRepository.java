package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    @Query(value = "select * from role where id_role like :#{#id}", nativeQuery = true)
    public Role findTheRoleById(@Param("id") Integer id);
}
