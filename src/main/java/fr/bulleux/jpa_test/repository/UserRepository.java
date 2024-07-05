package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Competence;
import fr.bulleux.jpa_test.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {


    @Query(value = "select * from user where id_user like :#{#id}", nativeQuery = true)
    public User findTheUserById(@Param("id") Integer id);



}
