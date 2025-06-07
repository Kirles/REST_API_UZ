package org.example.validation;

import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueWagonNumbersValidator.class)
public @interface UniqueWagonNumbers {
    String message() default "В одному поїзді не може бути вагонів з однаковим номером";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}

