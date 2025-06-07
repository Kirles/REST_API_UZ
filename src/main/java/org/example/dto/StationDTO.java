package org.example.dto;

import jakarta.validation.constraints.*;

public class StationDTO {
    private Long id;

    @NotBlank(message = "Назва станції обов'язкова")
    @Size(min = 3, max = 255, message = "Назва станції має містити не менше 3 символів")
    @Pattern(regexp = "^[А-ЯЁІЇЄа-яёіїє0-9\\-']+$", message = "Назва станції може містити лише кириличні літери, цифри, дефіс і апостроф")
    private String name;

    @NotBlank(message = "Код станції обов'язковий")
    @Min(value = 2200000, message = "Код станції має починатися з 22 і складатися з 7 цифр")
    @Max(value = 2299999, message = "Код станції має починатися з 22 і складатися з 7 цифр")
    private String code;

    public StationDTO() {}

    public StationDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "WagonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
