package za.co.javaspace.developerstarter.conditions;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(BlacklistName.class)
public @interface BlacklistNameCondition {
}
