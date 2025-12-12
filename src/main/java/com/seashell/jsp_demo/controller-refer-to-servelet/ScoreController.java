package com.seashell.jsp_demo.controller_refer_to_servlet; 

// Spring Web 相關
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model; //取代 set request attribute
import org.springframework.beans.factory.annotation.Autowired;

// Spring JDBC 相關
import org.springframework.jdbc.core.JdbcTemplate;

import com.seashell.jsp_demo.repository.ScoreRepository;
import com.seashell.jsp_demo.domain_object.Score;
// Java 集合相關
import java.util.List;
import java.util.Map;
import java.util.HashMap; // 如果你在方法體內使用了 HashMap，也需要導入

@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    private final JdbcTemplate jdbc;

    public ScoreController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/leaderboard")
    public String leaderboard(Model model) {
        List<Score> scores  =scoreRepository.getLeaderboard();
        model.addAttribute("scores", scores);
        return "leaderboard"; // 對應 /WEB-INF/views/leaderboard.jsp
    }
}
