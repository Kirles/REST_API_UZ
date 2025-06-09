package org.example.mapper;

import org.example.dto.WagonDTO;
import org.example.model.Train;
import org.example.model.Wagon;
import org.springframework.stereotype.Component;

@Component
public class WagonMapper {

    public WagonDTO toDto(Wagon wagon) {
        WagonDTO dto = new WagonDTO();
        dto.setTrainId(wagon.getTrain().getId());
        dto.setWagonNumber(wagon.getWagonNumber());
        return dto;
    }

    public Wagon toEntity(WagonDTO dto, Train train) {
        Wagon wagon = new Wagon();
        wagon.setTrain(train);
        wagon.setWagonNumber(dto.getWagonNumber());
        return wagon;
    }
}
