package org.example.service;

import org.example.dto.TrainDTO;
import org.example.mapper.TrainMapper;
import org.example.model.Train;
import org.example.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    private final TrainRepository trainRepository;
    private final TrainMapper trainMapper;

    public TrainService(TrainRepository trainRepository, TrainMapper trainMapper) {
        this.trainRepository = trainRepository;
        this.trainMapper = trainMapper;
    }

    public Train create(TrainDTO dto) {
        Train station = trainMapper.toEntity(dto);
        return trainRepository.save(station);
    }

    public List<Train> readAll() {
        return trainRepository.findAll();
    }

    public Train update(Train train) {
        return trainRepository.save(train);
    }

    public void delete(Long id) {
        trainRepository.deleteById(id);
    }

    public List<Train> findByNumber(String number) {
        return trainRepository.findByNumber(number);
    }

    public Train findById(Long id) {
        return trainRepository.findById(id);
    }

}
