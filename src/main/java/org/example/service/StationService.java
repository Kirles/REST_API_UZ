package org.example.service;

import org.example.dto.StationDTO;
import org.example.mapper.StationMapper;
import org.example.model.Station;
import org.example.repository.StationRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    public StationService(StationRepository stationRepository, StationMapper stationMapper) {
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
    }

    @CacheEvict(value = {"stations", "stationNamesByCode"}, allEntries = true)
    public Station create(StationDTO dto) {
        Station station = stationMapper.toEntity(dto);
        return stationRepository.save(station);
    }

    @Cacheable("stations")
    public List<Station> readAll() {
        return stationRepository.findAll();
    }

    @CacheEvict(value = {"stations", "stationNamesByCode"}, allEntries = true)
    public Station update(Station station) {
        return stationRepository.save(station);
    }

    @CacheEvict(value = {"stations", "stationNamesByCode"}, allEntries = true)
    public void delete(Long id) {
        stationRepository.deleteById(id);
    }

    @Cacheable(value = "stationNamesByCode", key = "#code")
    public List<String> getStationNameByCode(String code) {
        System.out.println("Fetching from DB: getStationNameByCode(" + code + ")");
        return stationRepository.findByCode(code);
    }

}
