package org.example.service;

import org.example.dto.TripDTO;
import org.example.mapper.TripMapper;
import org.example.model.Station;
import org.example.model.Train;
import org.example.model.Trip;
import org.example.repository.StationRepository;
import org.example.repository.TrainRepository;
import org.example.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final TrainRepository trainRepository;
    private final StationRepository stationRepository;
    private final TripMapper tripMapper;

    public TripService(TripRepository tripRepository, TrainRepository trainRepository, StationRepository stationRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.trainRepository = trainRepository;
        this.stationRepository = stationRepository;
        this.tripMapper = tripMapper;
    }

    public Trip create(TripDTO dto){
        Train train = trainRepository.findById(dto.getTrainId());
        Station fromStation = stationRepository.findById(dto.getFromStationId());
        Station toStation = stationRepository.findById(dto.getToStationId());
        Trip trip = tripMapper.toEntity(dto, train, fromStation, toStation);
        return tripRepository.save(trip);
    }

    public List<Trip> readAll() {
        return tripRepository.findAll();
    }

    public Trip update(Trip trip) {
        return tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }


    public Trip findById(Long id) {
        return tripRepository.findById(id);
    }

}
