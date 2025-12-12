package com.seashell.jsp_demo.controller_refer_to_servlet; 

// Spring Web 相關
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Spring JDBC 相關
import org.springframework.jdbc.core.JdbcTemplate;

// Java 集合相關
import java.util.List;
import java.util.Map;
import java.util.HashMap; // 如果你在方法體內使用了 HashMap，也需要導入

@RestController
@RequestMapping("/api")
public class ScoreController {

    private final JdbcTemplate jdbc;

    public ScoreController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @PostMapping("/score")
    public void addScore(@RequestBody Map<String, Object> body) {
        jdbc.update(
            "INSERT INTO scores(name, score) VALUES(?, ?)",
            body.get("name"), body.get("score")
        );
    }

    @GetMapping("/leaderboard")
    public List<Map<String, Object>> leaderboard() {
        return jdbc.queryForList(
            "SELECT name, score FROM scores ORDER BY score DESC FETCH FIRST 10 ROWS ONLY"
        );
    }
}
