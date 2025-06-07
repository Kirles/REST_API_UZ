package org.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.model.Train;
import org.example.model.Wagon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueWagonNumbersValidator implements ConstraintValidator<UniqueWagonNumbers, Train> {

    @Override
    public void initialize(UniqueWagonNumbers constraintAnnotation) {
    }

    @Override
    public boolean isValid(Train train, ConstraintValidatorContext context) {
        if (train == null) {
            return true;
        }

        List<Wagon> wagons = getWagonsList(train);
        if (wagons == null || wagons.isEmpty()) {
            return true;
        }

        Set<String> wagonNumbers = new HashSet<>();

        for (Wagon wagon : wagons) {
            String wagonNumber = getWagonNumber(wagon);
            if (wagonNumber != null) {
                if (!wagonNumbers.add(wagonNumber)) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<Wagon> getWagonsList(Train train) {
        try {
            return train.getWagons();
        } catch (Exception e) {
            return null;
        }
    }

    private String getWagonNumber(Wagon wagon) {
        try {
            return wagon.getWagonNumber();
        } catch (Exception e) {
            return null;
        }
    }
}