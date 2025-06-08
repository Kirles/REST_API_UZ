package org.example.mapper;

import org.example.dto.WagonDTO;
import org.example.model.Wagon;
import org.springframework.stereotype.Component;
import org.example.service.TrainService;

@Component
public class WagonMapper {

    private final TrainService trainService;

    public WagonMapper(TrainService trainService) {
        this.trainService = trainService;
    }

    public WagonDTO toDto(Wagon wagon) {
        WagonDTO dto = new WagonDTO();
        dto.setTrainId(wagon.getTrain().getId());
        dto.setWagonNumber(wagon.getWagonNumber());
        return dto;
    }

    public Wagon toEntity(WagonDTO dto) {
        Wagon wagon = new Wagon();
        wagon.setTrain(trainService.findById(dto.getTrainId()));
        wagon.setWagonNumber(dto.getWagonNumber());
        return wagon;
    }
}


