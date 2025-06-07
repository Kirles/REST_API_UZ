package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import org.example.model.Station;
import org.example.model.Train;
import org.example.validation.ValidTripStations;
import org.example.validation.ValidTripTime;

import java.time.LocalDateTime;

@ValidTripTime
@ValidTripStations
public class TripDTO {

    private Long id;

    @NotBlank(message = "Поїзд обов'язковий")
    private Train train;

    @NotBlank(message = "Станція відправлення обов'язкова")
    private Station fromStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_station_id", nullable = false)
    @NotBlank(message = "Станція прибуття обов'язкова")
    private Station toStation;

    @Column(name = "departure_time", nullable = false)
    @NotBlank(message = "Час відправлення обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @NotBlank(message = "Час прибуття обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime arrivalTime;

    public TripDTO() {}

    public TripDTO(Train train, Station fromStation, Station toStation, LocalDateTime departureTime, LocalDateTime arrivalTime) {
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
