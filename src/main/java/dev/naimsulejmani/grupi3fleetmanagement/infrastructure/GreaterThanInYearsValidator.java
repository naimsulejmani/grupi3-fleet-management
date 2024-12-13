package dev.naimsulejmani.grupi3fleetmanagement.infrastructure;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class GreaterThanInYearsValidator implements ConstraintValidator<GreaterThanInYears, LocalDate> {

    private int minAge;

    @Override
    public void initialize(GreaterThanInYears constraintAnnotation) {
        this.minAge = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) {
            return true; // Let @NotNull handle null values
        }
        return Period.between(birthDate, LocalDate.now()).getYears() >= minAge;
    }
}