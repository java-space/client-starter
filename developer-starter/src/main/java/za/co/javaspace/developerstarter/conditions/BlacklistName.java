package za.co.javaspace.developerstarter.conditions;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class BlacklistName extends SpringBootCondition {

    private static final String name = "developer.name";

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final ConditionMessage.Builder condition = ConditionMessage.forCondition(BlacklistNameCondition.class);

        final Environment environment = context.getEnvironment();

        if(environment.containsProperty(name)) {
            final String value = environment.getProperty(name);

            if(value.equalsIgnoreCase("JavaSpace")) {
                return ConditionOutcome.noMatch(
                        String.format("Name %s is black listed", value)
                );
            }
        } else {
            return ConditionOutcome.noMatch(
                    String.format("Name is missing")
            );
        }

        return ConditionOutcome.match();
    }
}
