package org.example.mapper;

import org.example.dto.StationDTO;
import org.example.model.Station;
import org.springframework.stereotype.Component;

@Component
public class StationMapper {

    public StationDTO toDto(Station station) {
        StationDTO dto = new StationDTO();
        dto.setName(station.getName());
        dto.setCode(station.getCode());
        return dto;
    }

    public Station toEntity(StationDTO dto) {
        Station station = new Station();
        station.setName(dto.getName());
        station.setCode(dto.getCode());
        return station;
    }
}
