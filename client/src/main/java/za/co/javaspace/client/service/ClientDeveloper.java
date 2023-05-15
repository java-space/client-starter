package za.co.javaspace.client.service;

import org.springframework.stereotype.Service;
import za.co.javaspace.developerstarter.service.DeveloperService;

@Service
public class ClientDeveloper implements DeveloperService {

    @Override
    public String name() {
        return "Hey You!";
    }
}
