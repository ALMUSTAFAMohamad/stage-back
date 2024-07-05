package fr.bulleux.jpa_test.repository;

import fr.bulleux.jpa_test.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    @Query(value = "select * from post where id_post like :#{#id}", nativeQuery = true)
    public Post findThePostById(@Param("id") Integer id);

    @Query(value = "select * from post where id_user_apprenti like :#{#id}", nativeQuery = true)
    public List <Post> findPostsApprenti(@Param("id") Integer id);

    @Query(value = "select * from post where id_user_posteur like :#{#id}", nativeQuery = true)
    public List <Post> findPostsPosteur(@Param("id") Integer id);

    @Query(value = "select * from post where id_user_apprenti like :#{#id1} and id_user_posteur like :#{#id2}", nativeQuery = true)
    public List <Post> findPostsApprentiPosteur(@Param("id1") Integer id1, @Param("id2") Integer id2);



}
