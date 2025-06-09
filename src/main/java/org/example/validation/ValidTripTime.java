package org.example.validation;

import jakarta.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TripTimeValidator.class)
public @interface ValidTripTime {
    String message() default "Час прибуття має бути пізніше часу відправлення";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
