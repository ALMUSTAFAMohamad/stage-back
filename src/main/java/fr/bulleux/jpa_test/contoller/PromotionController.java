package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Post;
import fr.bulleux.jpa_test.model.Promotion;
import fr.bulleux.jpa_test.model.Titre;
import fr.bulleux.jpa_test.repository.PromotionRepository;
import fr.bulleux.jpa_test.repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PromotionController {



// nouveau test
    @Autowired
    PromotionRepository repository;

    @Autowired
    TitreRepository titreRepository;

    @ResponseBody
    @GetMapping("/allPromotions")
    public List<Promotion> findAll(){
        return (List<Promotion>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getPromotion")
    public ResponseEntity<Promotion> findPromotionById(@RequestParam int id){
        return repository.findById(id)
                .map(promotion -> ResponseEntity.ok().body(promotion))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addPromotion")
    public boolean insert(@RequestParam String nom,
                          @RequestParam Integer id_titre){

        Promotion promotion = new Promotion(null, nom, null);
        promotion.setTitre(titreRepository.findTheTitreById(id_titre));
        repository.save(promotion);
        return true;//validation comme l'ajout d'une promotion est réussit
    }


    @ResponseBody
    @RequestMapping("/deletePromotion")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }


    @RequestMapping("/savePromotions")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Promotion> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }


}
