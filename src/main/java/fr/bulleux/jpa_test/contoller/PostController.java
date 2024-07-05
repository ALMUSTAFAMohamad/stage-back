package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Evaluation;
import fr.bulleux.jpa_test.model.Post;
import fr.bulleux.jpa_test.repository.PostRepository;
import fr.bulleux.jpa_test.repository.CompetenceRepository;
import fr.bulleux.jpa_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {



// nouveau test

    @Autowired
    PostRepository repository;


    @Autowired
    CompetenceRepository competenceRepository;

    @Autowired
    UserRepository userRepository;


    @ResponseBody
    @GetMapping("/allPosts")
    public List<Post> findAll(){
        return (List<Post>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getPost")
    public ResponseEntity<Post> findPostById(@RequestParam int id){
        return repository.findById(id)
                .map(post -> ResponseEntity.ok().body(post))
                .orElse(ResponseEntity.notFound().build());
    }


    @ResponseBody
    @RequestMapping("/getPostsApprenti")
    public List<Post> find(@RequestParam Integer id_apprenti){
        return repository.findPostsApprenti(id_apprenti);
    }


    @ResponseBody
    @RequestMapping("/getPostsPosteur")
    public List<Post> find2(@RequestParam Integer id_posteur){
        return repository.findPostsPosteur(id_posteur);
    }

    @ResponseBody
    @RequestMapping("/getPostsApprentiPosteur")
    public List<Post> find3(@RequestParam Integer id_apprenti,
                            @RequestParam Integer id_posteur) {
        return repository.findPostsApprentiPosteur(id_apprenti, id_posteur);
    }



    @ResponseBody
    @RequestMapping("/addPost")
    public boolean insert(@RequestParam String contenu,
                          @RequestParam Integer id_competence,
                          @RequestParam Integer id_apprenti,
                          @RequestParam Integer id_posteur){

        Post post = new Post
                (null, contenu, false,false, null, null, null);
        post.setCompetence(competenceRepository.findTheCompetenceById(id_competence));
        post.setApprenti(userRepository.findTheUserById(id_apprenti));
        post.setPosteur(userRepository.findTheUserById(id_posteur));
        repository.save(post);
        return true;//validation comme l'ajout est réussit
    }


    @ResponseBody
    @RequestMapping("/deletePost")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }


    @RequestMapping("/savePosts")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Post> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }



}
