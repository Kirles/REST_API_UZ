package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TrainDTO {

    private Long id;

    @NotBlank(message = "Номер поїзда обов'язковий")
    @Pattern(regexp = "^[0-9]{3}[А-ЯЁІЇЄа-яёіїє]$", message = "Номер поїзда має складатися з трьох цифр і кириличної літери (наприклад 001Л)")
    private String number;

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

    @Override
    public String toString() {
        return "WagonDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

}
