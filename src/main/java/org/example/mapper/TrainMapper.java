package org.example.mapper;

import org.example.dto.TrainDTO;
import org.example.dto.WagonDTO;
import org.example.model.Train;
import org.example.model.Wagon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainMapper {

    public static TrainDTO toDto(Train train) {
        if (train == null) return null;

        TrainDTO dto = new TrainDTO();
        dto.setNumber(train.getNumber());

        List<Wagon> wagons = train.getWagons();
        List<WagonDTO> wagonDTOS = null;
        for(Wagon wagon : wagons){
            assert false;
            wagonDTOS.add(WagonMapper.toDto(wagon));
        }

        dto.setWagonDTOS(wagonDTOS);

        return dto;
    }

    public static Train toEntity(TrainDTO dto) {
        if (dto == null) return null;

        Train train = new Train();
        train.setNumber(dto.getNumber());

        List<WagonDTO> wagonDTOS = dto.getWagonDTOS();
        List<Wagon> wagons = null;
        for(WagonDTO wagonDTO : wagonDTOS){
            assert false;
            wagons.add(WagonMapper.toEntity(wagonDTO));
        }
        train.setWagons(wagons);

        return train;
    }

}
