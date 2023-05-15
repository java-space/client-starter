package za.co.javaspace.developerstarter.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@AllArgsConstructor
public class ConsoleService {

    private final Logger logger = LoggerFactory.getLogger(ConsoleService.class);

    private DeveloperService developerService;

    @PostConstruct
    public void intBean() {
        run();
    }

    public void run() {
        logger.info(String.format("👨🏼‍%s😎",developerService.name()));
    }
}
