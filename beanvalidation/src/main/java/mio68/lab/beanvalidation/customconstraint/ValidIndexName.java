package mio68.lab.beanvalidation.customconstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = IndexNameValidator.class)
public @interface ValidIndexName {

    String message() default "Index name is invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
