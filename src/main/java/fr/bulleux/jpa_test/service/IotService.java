package fr.bulleux.jpa_test.service;

import fr.bulleux.jpa_test.model.Iot;
import fr.bulleux.jpa_test.repository.IotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Service
public class IotService {

    @Autowired
    IotRepository iotRepository;

    public List<Iot> getProductsByCategoryName(String name) {
        return iotRepository.findIotByMac(name);
    }

    public List<Map<String, OffsetDateTime>> getFrigo(){
        return iotRepository.findFrigoByMacDesc();
    }
}
