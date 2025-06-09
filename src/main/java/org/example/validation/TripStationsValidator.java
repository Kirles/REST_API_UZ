package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.dto.TripDTO;

import java.util.Objects;

public class TripStationsValidator implements ConstraintValidator<ValidTripStations, TripDTO> {

    @Override
    public void initialize(ValidTripStations constraintAnnotation) {
    }

    @Override
    public boolean isValid(TripDTO dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }

        if (dto.getFromStationId() == null || dto.getToStationId() == null) {
            return true;
        }

        return !(Objects.equals(dto.getFromStationId(), dto.getToStationId()));
    }
}
