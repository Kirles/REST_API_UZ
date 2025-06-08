package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_station_id", nullable = false)
    @NotBlank(message = "Станція відправлення обов'язкова")
    private Long fromStationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_station_id", nullable = false)
    @NotBlank(message = "Станція прибуття обов'язкова")
    private Long toStationId;

    @Column(name = "departure_time", nullable = false)
    @NotBlank(message = "Час відправлення обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @NotBlank(message = "Час прибуття обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime arrivalTime;

    public TripDTO() {}

    public TripDTO(Train train, Long fromStationId, Long toStationId, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.train = train;
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    public Long getFromStation() { return fromStationId; }
    public void setFromStation(Long fromStationid) { this.fromStationId = fromStationid; }

    public Long getToStation() { return toStationId; }
    public void setToStation(Long toStationid) { this.toStationId = toStationid; }

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
