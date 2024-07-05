package fr.bulleux.jpa_test.service.Utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenUtils {

    public String createToken(){
        UUID.randomUUID().toString().replace("-","");
        String uuidAsString = UUID.randomUUID().toString().replace("-","")+UUID.randomUUID().toString().replace("-","");
        return uuidAsString;
    }

}
