package org.example.mapper;

import org.example.dto.TrainDTO;
import org.example.dto.WagonDTO;
import org.example.model.Train;
import org.example.model.Wagon;
import org.example.service.WagonService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainMapper {

    private final WagonMapper wagonMapper;
    private final WagonService wagonService;

    public TrainMapper(WagonMapper wagonMapper, WagonService wagonService){
        this.wagonMapper = wagonMapper;
        this.wagonService = wagonService;
    }

    public TrainDTO toDto(Train train) {
        if (train == null) return null;

        TrainDTO dto = new TrainDTO();
        dto.setNumber(train.getNumber());

        List<Wagon> wagons = train.getWagons();
        List<Long> wagonsId = null;
        for (Wagon wagon : wagons) {
            wagonsId.add(wagonMapper.toDto(wagon).getId());
        }
        dto.setWagonsId(wagonsId);

        return dto;
    }

    public Train toEntity(TrainDTO dto) {
        if (dto == null) return null;

        Train train = new Train();
        train.setNumber(dto.getNumber());

        List<Long> wagonsId = dto.getWagonsId();
        List<Wagon> wagons = null;
        for(Long id : wagonsId){
            wagons.add(wagonService.findById(id));
        }
        train.setWagons(wagons);

        return train;
    }

}
