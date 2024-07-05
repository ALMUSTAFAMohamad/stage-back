package fr.bulleux.jpa_test.contoller;
import fr.bulleux.jpa_test.model.Module;
import fr.bulleux.jpa_test.repository.ModuleRepository;
import fr.bulleux.jpa_test.repository.ReferentielFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ModuleController {



    @Autowired
    ModuleRepository repository;

    @Autowired
    ReferentielFormationRepository rfRepository;

    @ResponseBody
    @GetMapping("/allModules")
    public List<Module> findAllModule(){
        return (List<Module>)repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getModule")
    public ResponseEntity<Module> findModuleById(@RequestParam int id){
        return repository.findById(id)
                .map(titre -> ResponseEntity.ok().body(titre))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addModule")
    public boolean insert(@RequestParam String nom,
                          @RequestParam String connaissance,
                          @RequestParam Integer id_rf){
        Module module = new Module(null,nom, connaissance, null);
        module.setRf(rfRepository.findTheReferentielFormationById(id_rf));
        repository.save(module);
        return true;
    }

    @ResponseBody
    @RequestMapping("/deleteModule")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }

    @RequestMapping("/saveModules")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Module> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }




}
