package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Competence;
import fr.bulleux.jpa_test.model.Titre;
import fr.bulleux.jpa_test.model.User;
import fr.bulleux.jpa_test.model.Promotion;
import fr.bulleux.jpa_test.repository.*;
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
public class UserController {



// nouveau test

    @Autowired
    UserRepository repository;





    @Autowired
    PromotionRepository promotionRepository;

    @Autowired
    StructureRepository structureRepository;

    @Autowired
    RoleRepository roleRepository;

    @ResponseBody
    @GetMapping("/allUsers")
    public List<User> findAll(){
        return (List<User>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getUser")
    public ResponseEntity<User> findUserById(@RequestParam int id){
        return repository.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public boolean insert(@RequestParam String prenom,
                          @RequestParam String nom,
                          @RequestParam Integer id_promotion,
                          @RequestParam Integer id_structure,
                          @RequestParam Integer id_role){

        User user = new User(null, prenom, nom, null, null, null);
        user.setPromotion(promotionRepository.findThePromotionById(id_promotion));
        user.setStructure(structureRepository.findTheStructureById(id_structure));
        user.setRole(roleRepository.findTheRoleById(id_role));
        repository.save(user);
        return true;//validation comme l'ajout est réussit
    }


    @ResponseBody
    @RequestMapping("/deleteUser")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }

    @RequestMapping("/saveUsers")
    public ResponseEntity<String> saveFromJson(@RequestBody List<User> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }




}
