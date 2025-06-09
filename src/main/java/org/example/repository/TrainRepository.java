package org.example.repository;

import org.example.model.Train;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class TrainRepository {

    private final JdbcTemplate jdbcTemplate;

    public TrainRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Train save(Train train) {
        String sql = "INSERT INTO train (number) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, train.getNumber());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            train.setId(generatedId.longValue());
        }

        return train;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM train WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Train> findAll() {
        String sql = "SELECT * FROM train";
        return jdbcTemplate.query(sql, new TrainRowMapper());
    }

    public List<Train> findByNumber(String number) {
        String sql = "SELECT * FROM train WHERE number = ?";
        return jdbcTemplate.query(sql, new Object[]{number}, new TrainRowMapper());
    }

    public Train findById(Long id) {
        String sql = "SELECT * FROM train WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TrainRowMapper());
    }

}

