package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Activite;
import fr.bulleux.jpa_test.model.Competence;
import fr.bulleux.jpa_test.model.Titre;
import fr.bulleux.jpa_test.repository.CompetenceRepository;
import fr.bulleux.jpa_test.repository.TitreRepository;
import fr.bulleux.jpa_test.repository.UserRepository;
import fr.bulleux.jpa_test.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class CompetenceController {



// nouveau test

    @Autowired
    CompetenceRepository repository;


    //.........
//    @Autowired
//    TitreRepository titreRepository;
    //.........


    @Autowired
    ActiviteRepository activiteRepository;

    @Autowired
    UserRepository userRepository;


    @ResponseBody
    @GetMapping("/allCompetences")
    public List<Competence> findAll(){
        return (List<Competence>) repository.findAllByOrderByIdActiviteAsc();

    }
    @ResponseBody
    @GetMapping("/getCompetence")
    public ResponseEntity<Competence> findUserById(@RequestParam int id){
        return repository.findById(id)
                .map(competence -> ResponseEntity.ok().body(competence))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addCompetence")
    public boolean insert(@RequestParam String nom,
                          @RequestParam boolean obligatoire,
                          @RequestParam boolean validee,
                          @RequestParam Integer id_activite,
                          @RequestParam Integer id_apprenti,
                          @RequestParam Integer id_formateur){

        Competence competence = new Competence
                (null, nom, obligatoire, validee, null, null, null);
        competence.setActivite(activiteRepository.findTheActiviteById(id_activite));
        competence.setApprenti(userRepository.findTheUserById(id_apprenti));
        competence.setFormateur(userRepository.findTheUserById(id_formateur));
        repository.save(competence);
        return true;//validation comme l'ajout est réussit
    }


    @ResponseBody
    @RequestMapping("/deleteCompetence")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }


    @RequestMapping("/saveCompetences")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Competence> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }



    @ResponseBody
    @RequestMapping("/competenceTest")
    public List <String> func(){
        List<String> competenceList = repository.testingCompetence();
        List<Competence> competences = new ArrayList<>();
        for (String string : competenceList) {
            Competence competence = new Competence();
            competence.setId_competence(Integer.getInteger(string));
            competences.add(competence);
        }

        return repository.testingCompetence();
    }


}
