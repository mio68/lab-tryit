package mio68.lab.beanvalidation.compositeconstraint;

import mio68.lab.beanvalidation.customconstraint.IndexNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@NotBlank
@Pattern(regexp = "[a-zA-Z0-9._\\-]+")
@Constraint(validatedBy = {})
public @interface ValidIndexName {

    String message() default "Index name is invalid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
