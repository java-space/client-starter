package za.co.javaspace.developerstarter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ConfigurationProperties("developer")
public class DeveloperProperties {

    /**
     * Name of a developer
     */
    private String name;

    /**
     * Experience of a developer
     */
    private String experience;

    /**
     * Coding language of developer
     */
    private String language;

    /**
     * Coding language of developer
     */
    private Gender gender;
}
