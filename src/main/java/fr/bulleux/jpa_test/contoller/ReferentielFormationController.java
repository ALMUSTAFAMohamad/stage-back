package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.*;
import fr.bulleux.jpa_test.model.Module;
import fr.bulleux.jpa_test.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReferentielFormationController {



// nouveau test

    @Autowired
    ReferentielFormationRepository repository;





    @Autowired
    TitreRepository titreRepository;



    @ResponseBody
    @GetMapping("/allReferentielFormations")
    public List<ReferentielFormation> findAll(){
        return (List<ReferentielFormation>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getReferentielFormation")
    public ResponseEntity<ReferentielFormation> findUserById(@RequestParam int id){
        return repository.findById(id)
                .map(referentielFormation -> ResponseEntity.ok().body(referentielFormation))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addReferentielFormation")
    public boolean insert(@RequestParam String nom,
                          @RequestParam Integer id_titre
                          ){
        ReferentielFormation rf = new ReferentielFormation(null, nom, null);
        rf.setNom(nom);
        rf.setTitre(titreRepository.findTheTitreById(id_titre));
        repository.save(rf);
        return true;//validation comme l'ajout est réussit
    }





    @ResponseBody
    @RequestMapping("/deleteReferentielFormation")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }

    @RequestMapping("/saveReferentielFormations")
    public ResponseEntity<String> saveFromJson(@RequestBody List<ReferentielFormation> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }


}
