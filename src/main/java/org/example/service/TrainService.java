package org.example.service;

import org.example.dto.TrainDTO;
import org.example.mapper.TrainMapper;
import org.example.model.Train;
import org.example.repository.TrainRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

    @CacheEvict(value = {"trains", "trainsByNumber", "trainById"}, allEntries = true)
    public Train create(TrainDTO dto) {
        Train station = trainMapper.toEntity(dto);
        return trainRepository.save(station);
    }

    @Cacheable("trains")
    public List<Train> readAll() {
        return trainRepository.findAll();
    }

    @CacheEvict(value = {"trains", "trainsByNumber", "trainById"}, allEntries = true)
    public Train update(Train train) {
        return trainRepository.save(train);
    }

    @CacheEvict(value = {"trains", "trainsByNumber", "trainById"}, allEntries = true)
    public void delete(Long id) {
        trainRepository.deleteById(id);
    }

    @Cacheable(value = "trainsByNumber", key = "#number")
    public List<Train> findByNumber(String number) {
        return trainRepository.findByNumber(number);
    }

    @Cacheable(value = "trainById", key = "#id")
    public Train findById(Long id) {
        return trainRepository.findById(id);
    }

}
