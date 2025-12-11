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
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper 將 ResultSet 塞入 User object
    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
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

    // 查詢所有 users
    public List<User> findAll() {
        String sql = "SELECT id, username, password, email, status, created_at, updated_at FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    // 根據 id 查單筆
    public User findById(int id) {
        String sql = "SELECT id, username, password, email, status, created_at, updated_at FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    // 新增 user
    public int save(User user) {
        String sql = "INSERT INTO users(username, password, email, status) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getStatus());
    }
}
