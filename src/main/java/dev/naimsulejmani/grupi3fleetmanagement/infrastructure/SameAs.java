package dev.naimsulejmani.grupi3fleetmanagement.infrastructure;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameAsValidator.class)
@Documented
public @interface SameAs {
    String message() default "Fields should match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field(); // Name of the field to compare with
}