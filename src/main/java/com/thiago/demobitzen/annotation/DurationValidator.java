package com.thiago.demobitzen.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class DurationValidator implements ConstraintValidator<ValidDuration, String> {

    private static final Pattern DURATION_PATTERN = Pattern.compile("^([0-5]?[0-9]):([0-5][0-9])$");

    @Override
    public void initialize(ValidDuration constraintAnnotation) {}

    @Override
    public boolean isValid(String duration, ConstraintValidatorContext context) {
        return duration != null && DURATION_PATTERN.matcher(duration).matches();
    }
}
