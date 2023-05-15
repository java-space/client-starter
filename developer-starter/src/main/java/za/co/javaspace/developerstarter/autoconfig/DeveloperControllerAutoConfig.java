package za.co.javaspace.developerstarter.autoconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import za.co.javaspace.developerstarter.controller.DeveloperDetailsController;
import za.co.javaspace.developerstarter.controller.DeveloperDetailsRestController;

@Configuration
@ComponentScan(basePackageClasses = {
        DeveloperDetailsController.class,
        DeveloperDetailsRestController.class})
public class DeveloperControllerAutoConfig {

}
