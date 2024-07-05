package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Iot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface IotRepository extends CrudRepository<Iot, Integer> {


    @Query(value = "select * from iot where mac like :#{#mac}", nativeQuery = true)
    public List<Iot> findIotByMac(@Param("mac") String mac);

    @Query(value = "select value,timestamp from iot where mac like 'EC:FA:BC:BC:67:BD' and sensor like '2' order by timestamp desc", nativeQuery = true)
    public List<Map<String, OffsetDateTime>> findFrigoByMacDesc();

    @Query(value = "select * from iot order by id desc limit :#{#number}", nativeQuery = true)
    public List<Iot> findLast(@Param("number") int number);

}
