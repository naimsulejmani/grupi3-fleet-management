package dev.naimsulejmani.grupi3fleetmanagement.infrastructure;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameAsValidator.class)
@Documented
public @interface SameAs {
    String fieldName();

    String message() default "{javax.validation.constraints.SameAs.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}