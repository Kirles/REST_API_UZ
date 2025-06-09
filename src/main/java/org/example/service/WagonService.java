package org.example.service;

import org.example.dto.WagonDTO;
import org.example.mapper.WagonMapper;
import org.example.model.Train;
import org.example.model.Wagon;
import org.example.repository.TrainRepository;
import org.example.repository.WagonRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagonService {

    private final WagonRepository wagonRepository;
    private final WagonMapper wagonMapper;
    private final TrainRepository trainRepository;

    public WagonService(WagonRepository wagonRepository, WagonMapper wagonMapper, TrainRepository trainRepository) {
        this.wagonRepository = wagonRepository;
        this.wagonMapper = wagonMapper;
        this.trainRepository = trainRepository;
    }

    @CacheEvict(value = {"wagons", "wagonByNumber", "wagonById"}, allEntries = true)
    public Wagon create(WagonDTO dto) {
        Train train = trainRepository.findById(dto.getTrainId());
        Wagon wagon = wagonMapper.toEntity(dto, train);
        return wagonRepository.save(wagon);
    }

    @Cacheable("wagons")
    public List<Wagon> readAll() {
        return wagonRepository.findAll();
    }

    @CacheEvict(value = {"wagons", "wagonByNumber", "wagonById"}, allEntries = true)
    public Wagon update(Wagon wagon) {
        return wagonRepository.save(wagon);
    }

    @CacheEvict(value = {"wagons", "wagonByNumber", "wagonById"}, allEntries = true)
    public void delete(Long id) {
        wagonRepository.deleteById(id);
    }

    @Cacheable(value = "wagonByNumber", key = "#wagonNumber")
    public List<Wagon> findByNumber(String wagonNumber) {
        return wagonRepository.findByWagonNumber(wagonNumber);
    }

    @Cacheable(value = "wagonById", key = "#id")
    public Wagon findById(Long id) {
        return wagonRepository.findById(id);
    }

}

