package org.example.repository;

import org.example.model.Trip;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TripRowMapper implements RowMapper<Trip> {

    private final TrainRepository trainRepository;
    private final StationRepository stationRepository;

    public TripRowMapper(TrainRepository trainRepository, StationRepository stationRepository){
        this.trainRepository = trainRepository;
        this.stationRepository = stationRepository;
    }

    @Override
    public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trip trip = new Trip();
        trip.setId(rs.getLong("id"));
        trip.setTrain(trainRepository.findById(rs.getLong("train_id")));
        trip.setFromStation(stationRepository.findById(rs.getLong("from_station_id")));
        trip.setToStation(stationRepository.findById(rs.getLong("to_station_id")));
        trip.setDepartureTime(rs.getTimestamp("departure_time").toLocalDateTime());
        trip.setArrivalTime(rs.getTimestamp("arrival_time").toLocalDateTime());
        return trip;
    }
}
