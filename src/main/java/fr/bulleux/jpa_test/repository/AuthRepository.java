package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Auth;
import fr.bulleux.jpa_test.model.Iot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<Auth,Integer> {
}
