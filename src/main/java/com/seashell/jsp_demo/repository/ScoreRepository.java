package com.seashell.jsp_demo.repository;

import com.seashell.jsp_demo.domain_object.Score; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ScoreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Score> userRowMapper = new RowMapper<Score>() {
        @Override
        public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Score(
                rs.getString("name"),
                rs.getInt("score")
            );
        }
    };

    public List<Score> getLeaderboard() {
        String sql = "SELECT name, score FROM scores ORDER BY score DESC FETCH FIRST 10 ROWS ONLY";
        return jdbcTemplate.query(sql, userRowMapper);
    }
}
