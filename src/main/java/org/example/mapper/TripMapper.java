package org.example.mapper;

import org.example.dto.TripDTO;
import org.example.model.Station;
import org.example.model.Train;
import org.example.model.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {
    public TripDTO toDto(Trip trip) {
        TripDTO dto = new TripDTO();
        dto.setTrainId(trip.getTrain().getId());
        dto.setFromStationID(trip.getFromStation().getId());
        dto.setToStationId(trip.getToStation().getId());
        dto.setDepartureTime(trip.getDepartureTime());
        dto.setArrivalTime(trip.getArrivalTime());
        return dto;
    }

    public Trip toEntity(TripDTO dto, Train train, Station fromStation, Station toStation) {
        Trip trip = new Trip();
        trip.setTrain(train);
        trip.setFromStation(fromStation);
        trip.setToStation(toStation);
        trip.setDepartureTime(dto.getDepartureTime());
        trip.setArrivalTime(dto.getArrivalTime());
        return trip;
    }
}
