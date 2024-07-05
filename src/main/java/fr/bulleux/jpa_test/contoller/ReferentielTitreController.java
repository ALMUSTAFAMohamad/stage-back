package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.ReferentielFormation;
import fr.bulleux.jpa_test.model.ReferentielTitre;
import fr.bulleux.jpa_test.repository.ReferentielFormationRepository;
import fr.bulleux.jpa_test.repository.ReferentielTitreRepository;
import fr.bulleux.jpa_test.repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReferentielTitreController {




    @Autowired
    ReferentielTitreRepository repository;





    @Autowired
    TitreRepository titreRepository;



    @ResponseBody
    @GetMapping("/allReferentielTitres")
    public List<ReferentielTitre> findAll(){
        return (List<ReferentielTitre>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getReferentielTitre")
    public ResponseEntity<ReferentielTitre> findUserById(@RequestParam int id){
        return repository.findById(id)
                .map(referentielTitre -> ResponseEntity.ok().body(referentielTitre))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addReferentielTitre")
    public boolean insert(@RequestParam String nom,
                          @RequestParam Integer id_titre
                          ){
        ReferentielTitre rt = new ReferentielTitre(null, nom, null);
        rt.setNom(nom);
        rt.setTitre(titreRepository.findTheTitreById(id_titre));
        repository.save(rt);
        return true;//validation comme l'ajout est réussit
    }





    @ResponseBody
    @RequestMapping("/deleteReferentielTitre")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }

    @RequestMapping("/saveReferentielTitres")
    public ResponseEntity<String> saveFromJson(@RequestBody List<ReferentielTitre> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }



}
