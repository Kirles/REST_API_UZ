package org.example.mapper;

import org.example.dto.WagonDTO;
import org.example.model.Wagon;
import org.springframework.stereotype.Component;

@Component
public class WagonMapper {

    public static WagonDTO toDto(Wagon wagon) {
        WagonDTO dto = new WagonDTO();
        dto.setTrain(wagon.getTrain());
        dto.setWagonNumber(wagon.getWagonNumber());
        dto.setWagonClass(wagon.getWagonClass());
        return dto;
    }

    public static Wagon toEntity(WagonDTO dto) {
        Wagon wagon = new Wagon();
        wagon.setTrain(dto.getTrain());
        wagon.setWagonNumber(dto.getWagonNumber());
        wagon.setWagonClass(dto.getWagonClass());
        return wagon;
    }
}
