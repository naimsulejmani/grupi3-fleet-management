package dev.naimsulejmani.grupi3fleetmanagement.infrastructure;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeast18YearsOldValidator.class)
@Documented
public @interface AtLeast18YearsOld {
    String message() default "Driver should be at least 18 years old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}