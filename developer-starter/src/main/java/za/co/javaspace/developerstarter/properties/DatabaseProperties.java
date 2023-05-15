package za.co.javaspace.developerstarter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("javaspace.connection")
public class DatabaseProperties {

    /**
     * Datasource of user
     */
    private String user;

    /**
     * Datasource of password
     */
    private String password;

    /**
     * Database name
     */
    private String database;
}
