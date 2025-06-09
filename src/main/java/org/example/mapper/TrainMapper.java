package org.example.mapper;

import org.example.dto.TrainDTO;
import org.example.model.Train;
import org.springframework.stereotype.Component;

@Component
public class TrainMapper {

    public TrainDTO toDto(Train train) {
        if (train == null) return null;

        TrainDTO dto = new TrainDTO();
        dto.setNumber(train.getNumber());

        return dto;
    }

    public Train toEntity(TrainDTO dto) {
        if (dto == null) return null;

        Train train = new Train();
        train.setNumber(dto.getNumber());

        return train;
    }

}
