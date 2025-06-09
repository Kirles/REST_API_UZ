package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.dto.TripDTO;

import java.time.LocalDateTime;

public class TripTimeValidator implements ConstraintValidator<ValidTripTime, TripDTO> {

    @Override
    public void initialize(ValidTripTime constraintAnnotation) {
    }

    @Override
    public boolean isValid(TripDTO dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }

        LocalDateTime departureTime = dto.getDepartureTime();
        LocalDateTime arrivalTime = dto.getArrivalTime();

        if (departureTime == null || arrivalTime == null) {
            return true;
        }

        return arrivalTime.isAfter(departureTime);
    }
}
