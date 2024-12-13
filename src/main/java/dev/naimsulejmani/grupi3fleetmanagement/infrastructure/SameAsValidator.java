package dev.naimsulejmani.grupi3fleetmanagement.infrastructure;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SameAsValidator implements ConstraintValidator<SameAs, Object> {

    private String fieldName;

    @Override
    public void initialize(SameAs constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Method method = object.getClass().getMethod("get" + capitalize(fieldName));
            Object firstObj = method.invoke(object);
            Method confirmMethod = object.getClass().getMethod("get" + capitalize("confirmPassword"));
            Object secondObj = confirmMethod.invoke(object);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}