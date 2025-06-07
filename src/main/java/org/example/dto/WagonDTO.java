package org.example.dto;

import jakarta.validation.constraints.*;
import org.example.model.Train;
import org.example.model.WagonClass;
import org.example.validation.UniqueWagonNumbers;

@UniqueWagonNumbers
public class WagonDTO {

    private Long id;

    private Train train;

    @NotBlank(message = "Номер вагона обов'язковий")
    @Pattern(regexp = "^[0-9]{2}[КПЛкпл]$", message = "Номер вагона має бути у форматі '01К', '02П', '03Л'")
    private String wagonNumber;

    private WagonClass wagonClass;

    public WagonDTO() {}

    public WagonDTO(Train train, String trainNumber, String wagonNumber) {
        this.train = train;
        this.wagonNumber = wagonNumber;
        this.wagonClass = extractWagonClass(wagonNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getWagonNumber() {
        return wagonNumber;
    }

    public void setWagonNumber(String wagonNumber) {
        this.wagonNumber = wagonNumber;
        this.wagonClass = extractWagonClass(wagonNumber);
    }

    private WagonClass extractWagonClass(String wagonNumber) {
        if (wagonNumber != null && wagonNumber.length() == 3) {
            char classChar = Character.toUpperCase(wagonNumber.charAt(2));
            try {
                return WagonClass.valueOf(String.valueOf(classChar));
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }

    public WagonClass getWagonClass() {
        return wagonClass;
    }

    public void setWagonClass(WagonClass wagonClass) {
        this.wagonClass = wagonClass;
    }

    public boolean hasTrainInfo() {
        return train != null;
    }

    @Override
    public String toString() {
        return "WagonDto{" +
                "id=" + id +
                ", train=" + train +
                ", wagonNumber='" + wagonNumber + '\'' +
                ", wagonClass=" + wagonClass +
                '}';
    }

}