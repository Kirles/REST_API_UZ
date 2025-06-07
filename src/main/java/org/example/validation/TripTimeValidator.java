package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.model.Trip;

import java.time.LocalDateTime;

public class TripTimeValidator implements ConstraintValidator<ValidTripTime, Trip> {

    @Override
    public void initialize(ValidTripTime constraintAnnotation) {
    }

    @Override
    public boolean isValid(Trip trip, ConstraintValidatorContext context) {
        if (trip == null) {
            return true;
        }

        LocalDateTime departureTime = trip.getDepartureTime();
        LocalDateTime arrivalTime = trip.getArrivalTime();

        if (departureTime == null || arrivalTime == null) {
            return true;
        }

        return arrivalTime.isAfter(departureTime);
    }
}
