package za.co.javaspace.developerstarter.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.javaspace.developerstarter.model.DeveloperDetails;

@AllArgsConstructor
@RestController
@RequestMapping("v2")
@ConditionalOnJava(value = JavaVersion.SEVENTEEN, range = ConditionalOnJava.Range.EQUAL_OR_NEWER)
public class DeveloperDetailsRestController {

    //private DriverService driverService;

    @GetMapping("developer")
    public DeveloperDetails driverDetails() {
        return new DeveloperDetails();
    }
}
