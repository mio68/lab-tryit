package mio68.lab.beanvalidation.customconstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IndexNameValidator implements ConstraintValidator<ValidIndexName, String> {

    private static final String NAME_PATTERN_REGEXP = "[a-zA-Z0-9._\\-]+";

    @Override
    public void initialize(ValidIndexName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        if (name == null || name.isBlank()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            String.format(
                                    "Index name [%s] is invalid, not blank value is required",
                                    name))
                    .addConstraintViolation();
            return false;
        } else {
            if (!name.matches(NAME_PATTERN_REGEXP)) {
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                                String.format(
                                        "Index name [%s] is invalid, doesn't match regexp [%s]",
                                        name,
                                        NAME_PATTERN_REGEXP))
                        .addConstraintViolation();
                return false;
            } else {
                return true;
            }
        }
    }

}
