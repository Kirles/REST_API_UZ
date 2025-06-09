package org.example.repository;

import org.example.model.Station;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StationRowMapper implements RowMapper<Station> {
    @Override
    public Station mapRow(ResultSet rs, int rowNum) throws SQLException {
        Station station = new Station();
        station.setId(rs.getLong("id"));
        station.setCode(rs.getString("code"));
        station.setName(rs.getString("name"));
        return station;
    }
}
