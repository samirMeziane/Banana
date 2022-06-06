package com.example.test.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = DateFutureValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFutureConstraint {
    String message() default "{com.example.test.validator.DateFutureConstraint.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
