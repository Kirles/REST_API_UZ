package org.example.repository;

import org.example.model.Wagon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class WagonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final WagonRowMapper wagonRowMapper;


    public WagonRepository(JdbcTemplate jdbcTemplate, WagonRowMapper wagonRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.wagonRowMapper = wagonRowMapper;
    }

    public Wagon save(Wagon wagon) {
        String sql = "INSERT INTO wagon (train_id, wagon_number) VALUES (?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setLong(1, wagon.getTrain().getId());
            ps.setString(2, wagon.getWagonNumber());
            return ps;
        }, keyHolder);

        Number generatedId = keyHolder.getKey();
        if (generatedId != null) {
            wagon.setId(generatedId.longValue());
        }

        return wagon;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM wagon WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Wagon> findAll() {
        String sql = "SELECT * FROM wagon";
        return jdbcTemplate.query(sql, wagonRowMapper);
    }

    public List<Wagon> findByWagonNumber(String wagonNumber) {
        String sql = "SELECT * FROM wagon WHERE wagon_number = ?";
        return jdbcTemplate.query(sql, new Object[]{wagonNumber}, wagonRowMapper);
    }

    public Wagon findById(Long id) {
        String sql = "SELECT * FROM wagon WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, wagonRowMapper);
    }

}



