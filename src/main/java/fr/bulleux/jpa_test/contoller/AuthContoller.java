package fr.bulleux.jpa_test.contoller;

import fr.bulleux.jpa_test.model.Auth;
import fr.bulleux.jpa_test.repository.AuthRepository;
import fr.bulleux.jpa_test.service.Utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthContoller {

    @Autowired
    AuthRepository authRepository;

    @Autowired
    TokenUtils tokenUtils;

    @ResponseBody
    @RequestMapping("auth")
    public List<Auth> findAuthAll(){
        return (List<Auth>) authRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "token", method = RequestMethod.GET)
    public String createToken(@RequestParam String username,
                              @RequestParam String password){
        String token = tokenUtils.createToken();
        List<Auth> authList = (List<Auth>) authRepository.findAll();
        for (Auth auth : authList) {
            if(auth.getUsername().equals(username) && auth.getPassword().equals(password)){
                Optional<Auth> byId = authRepository.findById(auth.getId());
                Auth customer = byId.get();
                customer.setToken(token);
                authRepository.save(customer);
                return token;
            }
        }
    return "you are not authorized !";

    }

    @ResponseBody
    @RequestMapping(value = "secret", method = RequestMethod.GET)
    public String pathToken(@RequestParam String param){
        byte[] decodedBytes = Base64.getDecoder().decode(param);
        String decodedString = new String(decodedBytes);
        String[] split = decodedString.split(",");
        String username = split[0];
        String pwd = split[1];

        return  decodedString;
    }
}
