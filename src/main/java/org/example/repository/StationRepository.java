package org.example.repository;

import org.example.model.Station;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StationRepository {

    private final JdbcTemplate jdbcTemplate;

    public StationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Station save(Station station) {
        String sql = "INSERT INTO station (code, name) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, station.getCode());
            ps.setString(2, station.getName());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            station.setId(generatedId.longValue());
        }

        return station;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM station WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Station> findAll() {
        String sql = "SELECT * FROM station";
        return jdbcTemplate.query(sql, new StationRowMapper());
    }

    public List<Station> findByCode(String code) {
        String sql = "SELECT * FROM station WHERE code = ?";
        return jdbcTemplate.query(sql, new Object[]{code}, new StationRowMapper());
    }

    private static class StationRowMapper implements RowMapper<Station> {
        @Override
        public Station mapRow(ResultSet rs, int rowNum) throws SQLException {
            Station station = new Station();
            station.setId(rs.getLong("id"));
            station.setCode(rs.getString("code"));
            station.setName(rs.getString("name"));
            return station;
        }
    }
}
