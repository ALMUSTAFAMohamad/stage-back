package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Iot;
import fr.bulleux.jpa_test.model.ReferentielTitre;
import fr.bulleux.jpa_test.model.Role;
import fr.bulleux.jpa_test.model.Structure;
import fr.bulleux.jpa_test.repository.IotRepository;
import fr.bulleux.jpa_test.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class StructureController {



// nouveau test
    @Autowired
StructureRepository repository;

    @ResponseBody
    @RequestMapping("/allStructures")
    public List<Structure> findAll(){
        return (List<Structure>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getStructure")
    public ResponseEntity<Structure> findStructureById(@RequestParam int id){
        return repository.findById(id)
                .map(structure -> ResponseEntity.ok().body(structure))
                .orElse(ResponseEntity.notFound().build());
    }


    @ResponseBody
    @RequestMapping("/addStructure")
    public boolean insert(@RequestParam String nom){
        Structure structure = new Structure(null,nom);
        repository.save(structure);
        return true;
    }

    @ResponseBody
    @RequestMapping("/deleteStructure")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }

    @RequestMapping("/saveStructures")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Structure> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }


}
