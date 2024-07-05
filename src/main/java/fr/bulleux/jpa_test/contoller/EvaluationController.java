package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Activite;
import fr.bulleux.jpa_test.model.Evaluation;
import fr.bulleux.jpa_test.model.User;
import fr.bulleux.jpa_test.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EvaluationController {



// nouveau test

    @Autowired
    EvaluationRepository repository;





    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    UserRepository userRepository;


    @ResponseBody
    @GetMapping("/allEvaluations")
    public List<Evaluation> findAll(){
        return (List<Evaluation>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getEvaluation")
    public ResponseEntity<Evaluation> findUserById(@RequestParam int id){
        return repository.findById(id)
                .map(evaluation -> ResponseEntity.ok().body(evaluation))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addEvaluation")
    public boolean insert(@RequestParam String description,
                          @RequestParam double note,
                          @RequestParam Integer id_module,
                          @RequestParam Integer id_apprenti,
                          @RequestParam Integer id_formateur){

        Evaluation evaluation = new Evaluation
                (null, description, note, null, null, null);
        evaluation.setModule(moduleRepository.findTheModuleById(id_module));
        evaluation.setApprenti(userRepository.findTheUserById(id_apprenti));
        evaluation.setFormateur(userRepository.findTheUserById(id_formateur));
        repository.save(evaluation);
        return true;//validation comme l'ajout est réussit
    }


    @ResponseBody
    @RequestMapping("/deleteEvaluation")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }


    @RequestMapping("/saveEvaluations")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Evaluation> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }


}
