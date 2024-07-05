package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Structure;
import fr.bulleux.jpa_test.model.Titre;
import fr.bulleux.jpa_test.repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TitreController {



// nouveau test
    @Autowired
TitreRepository repository;






    @ResponseBody
    @GetMapping("/allTitres")
    public List<Titre> findAll(){
        return (List<Titre>) repository.findAll();

    }


    @ResponseBody
    @RequestMapping("/addTitre")
    public boolean insert(@RequestParam String nom,
                          @RequestParam int millesime,
                          @RequestParam int niveau){
        Titre titre = new Titre(null,nom, millesime, niveau);
        repository.save(titre);
        return true;
    }

    @ResponseBody
    @RequestMapping("/deleteTitre")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }


    @ResponseBody
    @GetMapping("/getTitre")
    public ResponseEntity<Titre> findTitreById(@RequestParam int id){
        return repository.findById(id)
                .map(titre -> ResponseEntity.ok().body(titre))
                .orElse(ResponseEntity.notFound().build());

    }

    @RequestMapping("/saveTitres")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Titre> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }



}
