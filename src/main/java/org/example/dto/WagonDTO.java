package org.example.dto;

import jakarta.validation.constraints.*;
import org.example.validation.UniqueWagonNumbers;

@UniqueWagonNumbers
public class WagonDTO {

    private Long id;

    private Long trainId;

    @NotBlank(message = "Номер вагона обов'язковий")
    @Pattern(regexp = "^[0-9]{2}[КПЛкпл]$", message = "Номер вагона має бути у форматі '01К', '02П', '03Л'")
    private String wagonNumber;

    public WagonDTO() {}

    public WagonDTO(Long trainId, String wagonNumber) {
        this.trainId = trainId;
        this.wagonNumber = wagonNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getWagonNumber() {
        return wagonNumber;
    }

    public void setWagonNumber(String wagonNumber) {
        this.wagonNumber = wagonNumber;
    }

    @Override
    public String toString() {
        return "WagonDto{" +
                "id=" + id +
                ", trainId=" + trainId +
                ", wagonNumber='" + wagonNumber +
                '}';
    }

}