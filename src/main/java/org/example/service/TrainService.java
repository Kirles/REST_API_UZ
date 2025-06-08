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

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public Train create(TrainDTO dto) {
        Train station = TrainMapper.toEntity(dto);
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

}
