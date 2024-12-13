package dev.naimsulejmani.grupi3fleetmanagement.infrastructure;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AtLeast18YearsOldValidator implements ConstraintValidator<AtLeast18YearsOld, LocalDate> {

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return true; // Let @NotNull handle null values
        }
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }
}
