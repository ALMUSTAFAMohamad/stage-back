package fr.bulleux.jpa_test.contoller;
import fr.bulleux.jpa_test.model.Activite;
import fr.bulleux.jpa_test.model.Role;
import fr.bulleux.jpa_test.repository.ActiviteRepository;
import fr.bulleux.jpa_test.repository.ReferentielTitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ActiviteController {


    @Autowired
    ActiviteRepository repository;

    @Autowired
    ReferentielTitreRepository rtRepository;

    @ResponseBody
    @GetMapping("/allActivites")
    public List<Activite> findAllModule() {
        return (List<Activite>) repository.findAll();

    }

    @ResponseBody
    @GetMapping("/getActivite")
    public ResponseEntity<Activite> findModuleById(@RequestParam int id) {
        return repository.findById(id)
                .map(activite -> ResponseEntity.ok().body(activite))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addActivite")
    public boolean insert(@RequestParam String nom,
                          @RequestParam Integer id_rt) {
        Activite activite = new Activite(null, nom, null);
        activite.setRt(rtRepository.findTheReferentielTitreById(id_rt));
        repository.save(activite);
        return true;
    }

    @ResponseBody
    @RequestMapping("/deleteActivite")
    public boolean ok(@RequestParam int id) {
        repository.deleteById(id);
        return true;
    }

    @RequestMapping("/saveActivites")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Activite> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }

    //........................
    @ResponseBody
    @RequestMapping("/activiteList")
    public List<Integer> func(){
        return repository.activiteList();
        //return Arrays.asList(1, 2, 3);
    }


//    @ResponseBody
//    @GetMapping("/allActivites")
//    public List<Activite> findAllModule() {
//        return (List<Activite>) repository.findAll();
//
//    }
    //........................

}
