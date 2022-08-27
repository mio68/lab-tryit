package mio68.lab.beanvalidation.customconstraint;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndexNameValidatorTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenNameIsNull_thenConstraintViolation() {
        Index index = Index.builder().name(null).build();
        Set<ConstraintViolation<Index>> constraintViolations = validator.validate(index);
        System.out.println(constraintViolations);
        assertFalse(constraintViolations.isEmpty());
    }

    @Test
    void whenNameIsEmpty_thenConstraintViolation() {
        Index index = Index.builder().name("").build();
        Set<ConstraintViolation<Index>> constraintViolations = validator.validate(index);
        System.out.println(constraintViolations);
        assertFalse(constraintViolations.isEmpty());
    }

    @Test
    void whenNameIsBlank_thenConstraintViolation() {
        Index index = Index.builder().name("   ").build();
        Set<ConstraintViolation<Index>> constraintViolations = validator.validate(index);
        System.out.println(constraintViolations);
        assertFalse(constraintViolations.isEmpty());
    }

    @Test
    void whenNameIsCorrect_thenOk() {
        Index index = Index.builder().name("Project-A.index_01").build();
        Set<ConstraintViolation<Index>> constraintViolations = validator.validate(index);
        System.out.println(constraintViolations);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    void whenNameHasInvalidSymbol_thenOk() {
        Index index = Index.builder().name("Project-A.index#01").build();
        Set<ConstraintViolation<Index>> constraintViolations = validator.validate(index);
        System.out.println(constraintViolations);
        assertFalse(constraintViolations.isEmpty());
    }

}