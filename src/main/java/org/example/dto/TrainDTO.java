package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class TrainDTO {

    private Long id;

    @NotBlank(message = "Номер поїзда обов'язковий")
    @Pattern(regexp = "^[0-9]{3}[А-ЯЁІЇЄа-яёіїє]$", message = "Номер поїзда має складатися з трьох цифр і кириличної літери (наприклад 001Л)")
    private String number;

    private List<WagonDTO> wagonDTOS;

    private List<TripDTO> tripDTOS;

    public TrainDTO() {}

    public TrainDTO(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setWagonDTOS(List<WagonDTO> wagonDTOS) {
        this.wagonDTOS = wagonDTOS;
    }

    public List<WagonDTO> getWagonDTOS() {
        return wagonDTOS;
    }

    public void setTripDTOS(List<TripDTO> tripDTOS) {
        this.tripDTOS = tripDTOS;
    }

    public List<TripDTO> getTripDTOS() {
        return tripDTOS;
    }

    @Override
    public String toString() {
        return "WagonDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

}
