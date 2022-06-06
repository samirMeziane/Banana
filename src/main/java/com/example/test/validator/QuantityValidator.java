package com.example.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuantityValidator implements ConstraintValidator<QuantityConstraint, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        int intValue = value.intValue();
        return 0<intValue && intValue<10000 && intValue%25==0 ;
    }
}
