package org.example.repository;

import org.example.model.Trip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class TripRepository {

    private final JdbcTemplate jdbcTemplate;
    private final TripRowMapper tripRowMapper;

    public TripRepository(JdbcTemplate jdbcTemplate, TripRowMapper tripRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.tripRowMapper = tripRowMapper;
    }

    public Trip save(Trip trip) {
        String sql = "INSERT INTO trip (train_id, from_station_id, to_station_id, departure_time, arrival_time) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setLong(1, trip.getTrain().getId());
            ps.setLong(2, trip.getFromStation().getId());
            ps.setLong(3, trip.getToStation().getId());
            ps.setObject(4, trip.getDepartureTime());
            ps.setObject(5, trip.getArrivalTime());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            trip.setId(generatedId.longValue());
        }

        return trip;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM trip WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Trip> findAll() {
        String sql = "SELECT * FROM trip";
        return jdbcTemplate.query(sql, tripRowMapper);
    }

    public Trip findById(Long id) {
        String sql = "SELECT * FROM trip WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, tripRowMapper);
    }

}
