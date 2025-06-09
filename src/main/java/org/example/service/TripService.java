package org.example.service;

import org.example.repository.TripRepository;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final TrainService trainService;

    public TripService(TripRepository tripRepository, TrainService trainService){
        this.tripRepository = tripRepository;
        this.trainService = trainService;
    }
}
