package com.example.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateFutureValidator implements ConstraintValidator<DateFutureConstraint, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return !value.minusDays(7).isBefore(LocalDate.now());
    }
}
