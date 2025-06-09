package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.validation.ValidTripStations;
import org.example.validation.ValidTripTime;

import java.time.LocalDateTime;

@ValidTripTime
@ValidTripStations
public class TripDTO {

    private Long id;

    @NotNull(message = "Поїзд обов'язковий")
    private Long trainId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_station_id", nullable = false)
    @NotNull(message = "Станція відправлення обов'язкова")
    private Long fromStationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_station_id", nullable = false)
    @NotNull(message = "Станція прибуття обов'язкова")
    private Long toStationId;

    @Column(name = "departure_time", nullable = false)
    @NotNull(message = "Час відправлення обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    @NotNull(message = "Час прибуття обов'язковий")
    @Future(message = "Час відправлення має бути в майбутньому")
    private LocalDateTime arrivalTime;

    public TripDTO() {}

    public TripDTO(Long trainId, Long fromStationId, Long toStationId, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.trainId = trainId;
        this.fromStationId = fromStationId;
        this.toStationId = toStationId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTrainId() { return trainId; }
    public void setTrainId(Long trainId) { this.trainId = trainId; }

    public Long getFromStationId() { return fromStationId; }
    public void setFromStationID(Long fromStationId) { this.fromStationId = fromStationId; }

    public Long getToStationId() { return toStationId; }
    public void setToStationId(Long toStationId) { this.toStationId = toStationId; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    @Override
    public String toString() {
        return "TripDTO{" +
                "id=" + id +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

}
