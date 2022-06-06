package com.example.test.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = QuantityValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface QuantityConstraint {
    String message() default "{com.example.test.validator.QuantityConstraint.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
