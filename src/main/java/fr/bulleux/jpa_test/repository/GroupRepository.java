package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group,Integer> {
}
