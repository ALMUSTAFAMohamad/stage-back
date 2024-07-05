package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Module;
import fr.bulleux.jpa_test.model.Role;
import fr.bulleux.jpa_test.repository.RoleRepository;
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
public class RoleController {



// nouveau test
    @Autowired
RoleRepository repository;

    @ResponseBody
    @GetMapping("/allRoles")
    public List<Role> findAllRole(){
        return (List<Role>) repository.findAll();

    }
    @ResponseBody
    @GetMapping("/getRole")
    public ResponseEntity<Role> findRoleById(@RequestParam int id){
        return repository.findById(id)
                .map(role -> ResponseEntity.ok().body(role))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseBody
    @RequestMapping("/addRole")
    public boolean insert(@RequestParam String description){
        Role role = new Role(null,description);
        repository.save(role);
        return true;
    }

    @ResponseBody
    @RequestMapping("/deleteRole")
    public boolean ok(@RequestParam int id){
        repository.deleteById(id);
        return true;
    }


    @RequestMapping("/saveRoles")
    public ResponseEntity<String> saveFromJson(@RequestBody List<Role> json) {
        repository.saveAll(json);
        return ResponseEntity.ok("Data saved");
    }




}
