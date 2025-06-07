package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.validation.ValidTripStations;
import org.example.validation.ValidTripTime;

import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
@ValidTripTime
@ValidTripStations
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", nullable = false)
    @NotNull(message = "Поїзд обов'язковий для поїздки")
    private Train train;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_station_id", nullable = false)
    @NotNull(message = "Станція відправлення обов'язкова")
    private Station fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", nullable = false)
    @NotNull(message = "Станція прибуття обов'язкова")
    private Station toStation;

    @Column(name = "departure_time", nullable = false)
    @NotNull(message = "Час відправлення обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @NotNull(message = "Час прибуття обов'язковий")
    private LocalDateTime arrivalTime;

    public Trip() {}

    public Trip(Train train, Station fromStation, Station toStation,
                LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.train = train;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    public Station getFromStation() { return fromStation; }
    public void setFromStation(Station fromStation) { this.fromStation = fromStation; }

    public Station getToStation() { return toStation; }
    public void setToStation(Station toStation) { this.toStation = toStation; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
