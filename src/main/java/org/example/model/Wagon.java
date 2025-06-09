package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "wagon", uniqueConstraints = @UniqueConstraint(columnNames = {"train_id", "wagon_number"}))
public class Wagon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    @NotNull(message = "Поїзд обов'язковий для вагона")
    private Train train;

    @Column(name = "wagon_number", nullable = false, length = 3)
    @NotBlank(message = "Номер вагона обов'язковий")
    @Pattern(regexp = "^[0-9]{2}[КПЛкпл]$", message = "Номер вагона має бути у форматі '01К', '02П', '03Л'")
    private String wagonNumber;

    public Wagon() {}

    public Wagon(Train train, String wagonNumber) {
        this.train = train;
        this.wagonNumber = wagonNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    public String getWagonNumber() { return wagonNumber; }
    public void setWagonNumber(String wagonNumber) {
        this.wagonNumber = wagonNumber;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "id=" + id +
                ", wagonNumber='" + wagonNumber +
                '}';
    }
}