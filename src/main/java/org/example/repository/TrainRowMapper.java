package org.example.repository;

import org.example.model.Train;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TrainRowMapper implements RowMapper<Train> {
    @Override
    public Train mapRow(ResultSet rs, int rowNum) throws SQLException {
        Train train = new Train();
        train.setId(rs.getLong("id"));
        train.setNumber(rs.getString("number"));
        return train;
    }
}
