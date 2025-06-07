package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.model.Trip;

public class TripStationsValidator implements ConstraintValidator<ValidTripStations, Trip> {

    @Override
    public void initialize(ValidTripStations constraintAnnotation) {
    }

    @Override
    public boolean isValid(Trip trip, ConstraintValidatorContext context) {
        if (trip == null) {
            return true;
        }

        if (trip.getFromStation() == null || trip.getToStation() == null) {
            return true;
        }

        return !trip.getFromStation().getId().equals(trip.getToStation().getId());
    }
}
