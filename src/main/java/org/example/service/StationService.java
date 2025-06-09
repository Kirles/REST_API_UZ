package org.example.service;

import org.example.dto.StationDTO;
import org.example.mapper.StationMapper;
import org.example.model.Station;
import org.example.repository.StationRepository;
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

    public Station create(StationDTO dto) {
        Station station = stationMapper.toEntity(dto);
        return stationRepository.save(station);
    }

    public List<Station> readAll() {
        return stationRepository.findAll();
    }

    public Station update(Station station) {
        return stationRepository.save(station);
    }

    public void delete(Long id) {
        stationRepository.deleteById(id);
    }

    public List<String> getStationNameByCode(String code) {
        return stationRepository.findByCode(code);
    }

}
