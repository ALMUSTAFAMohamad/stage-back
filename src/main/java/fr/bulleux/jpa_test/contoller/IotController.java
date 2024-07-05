package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Iot;
import fr.bulleux.jpa_test.repository.IotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class IotController {



// nouveau test
    @Autowired
    IotRepository repository;

    @ResponseBody
    @RequestMapping("/find")
    public List<Iot> findAll(){
        return (List<Iot>) repository.findAll();

    }

    @ResponseBody
    @RequestMapping("/findLast")
    public List<Iot> findLast(@RequestParam int number){
        return (List<Iot>) repository.findLast(number);

    }

    @ResponseBody
    @RequestMapping("/frigo")
    public List<Iot> frigoAll(@RequestParam String mac){
        return (List<Iot>) repository.findIotByMac(mac);
    }

    @ResponseBody
    @RequestMapping("/frigod")
    public List<Map<String,OffsetDateTime>> frigoAllDesc(){
        return (List<Map<String,OffsetDateTime>>) repository.findFrigoByMacDesc();
    }

    @ResponseBody
    @RequestMapping("/iot")
    public String insert(@RequestParam String mac,
                         @RequestParam String sensor,
                         @RequestParam String value){
        Iot iot = new Iot(null,mac,sensor,value,OffsetDateTime.now());
        return repository.save(iot).toString();
    }


}
