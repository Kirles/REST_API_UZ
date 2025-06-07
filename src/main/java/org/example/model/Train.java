package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, unique = true, length = 4)
    @NotBlank(message = "Номер поїзда обов'язковий")
    @Pattern(regexp = "^[0-9]{3}[А-ЯЁІЇЄа-яёіїє]$",
            message = "Номер поїзда має складатися з трьох цифр і кириличної літери (наприклад 001Л)")
    private String number;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotEmpty(message = "Поїзд має складатися щонайменше з одного вагона")
    private List<Wagon> wagons;

    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
    private List<Trip> trips;

    public Train() {}

    public Train(String number) {
        this.number = number;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public List<Wagon> getWagons() { return wagons; }
    public void setWagons(List<Wagon> wagons) { this.wagons = wagons; }

    public List<Trip> getTrips() { return trips; }
    public void setTrips(List<Trip> trips) { this.trips = trips; }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}

