package za.co.javaspace.developerstarter.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import za.co.javaspace.developerstarter.conditions.BlacklistNameCondition;
import za.co.javaspace.developerstarter.properties.DeveloperProperties;
import za.co.javaspace.developerstarter.service.ConsoleService;
import za.co.javaspace.developerstarter.service.DefaultDeveloper;
import za.co.javaspace.developerstarter.service.DeveloperService;

@Configuration
@ConditionalOnClass(DeveloperService.class)
@EnableConfigurationProperties({DeveloperProperties.class})
@BlacklistNameCondition
public class DeveloperServiceAutoConfig {

    private final Logger logger = LoggerFactory.getLogger(DeveloperServiceAutoConfig.class);

    @Bean
    @ConditionalOnMissingBean
    public DeveloperService developerService(DeveloperProperties developerProperties) {
        return new DefaultDeveloper(
                String.format("%s %s %s %s",
                        developerProperties.getName(), developerProperties.getLanguage(), developerProperties.getExperience(),
                        developerProperties.getGender())
        );
    }

    @Bean
    @ConditionalOnJava(value = JavaVersion.SEVENTEEN, range = ConditionalOnJava.Range.EQUAL_OR_NEWER)
    public ConsoleService consoleService(DeveloperService developerService) {
        return new ConsoleService(
                developerService
        );
    }
}
