package za.co.javaspace.developerstarter.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import za.co.javaspace.developerstarter.conditions.MySQLOnClassPath;
import za.co.javaspace.developerstarter.properties.DatabaseProperties;
import za.co.javaspace.developerstarter.service.ConsoleService;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Optional;
import java.util.ServiceLoader;

@Configuration
@Conditional(MySQLOnClassPath.class)
@EnableConfigurationProperties(DatabaseProperties.class)
public class CreateDBAutoConfig {

    private final Logger logger = LoggerFactory.getLogger(ConsoleService.class);

    @Bean
    public DataSource oracle() {
        logger.info("😂Data source😂");
        final String url = "jdbc:mysql://localhost:3306/";
        final Optional<Driver> serviceLoader = ServiceLoader.load(Driver.class).findFirst();
        final Driver driver = serviceLoader.orElseThrow(() -> new RuntimeException("Driver not found"));
        final String user = "root";
        final String password = "blessing";
        return new SimpleDriverDataSource(
                driver,
                url,
                user,
                password
        );
    }

}
