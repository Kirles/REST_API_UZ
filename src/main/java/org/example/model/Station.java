package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    @NotBlank(message = "Назва станції обов'язкова")
    @Size(min = 3, max = 255, message = "Назва станції має містити не менше 3 символів")
    @Pattern(regexp = "^[А-ЯЁІЇЄа-яёіїє0-9\\-']+$", message = "Назва станції може містити лише кириличні літери, цифри, дефіс і апостроф")
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    @NotNull(message = "Код станції обов'язковий")
    @Pattern(regexp = "^22\\d{5}$", message = "Код станції має починатися з 22 і складатися з 7 цифр")
    private String code;

    public Station() {}

    public Station(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
