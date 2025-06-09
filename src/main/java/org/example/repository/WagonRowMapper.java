package org.example.repository;

import org.example.model.Wagon;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WagonRowMapper implements RowMapper<Wagon> {

    private final TrainRepository trainRepository;

    public WagonRowMapper(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    @Override
    public Wagon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Wagon wagon = new Wagon();
        wagon.setId(rs.getLong("id"));
        wagon.setTrain(trainRepository.findById(rs.getLong("train_id")));
        wagon.setWagonNumber(rs.getString("wagon_number"));
        return wagon;
    }
}
