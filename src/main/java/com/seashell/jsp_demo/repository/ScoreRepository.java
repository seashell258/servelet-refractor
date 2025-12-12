package com.seashell.jsp_demo.repository;

import com.seashell.jsp_demo.domain_object.User; 
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
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getByte("status"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")
            );
        }
    };


}
