package org.example.validation;

import jakarta.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TripStationsValidator.class)
public @interface ValidTripStations {
    String message() default "Станція відправлення не може дорівнювати станції прибуття";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
