package com.seashell.jsp_demo.domain_object;

import java.sql.Timestamp;

public class Score {
    private String name;
    private int score; // 對應 Oracle NUMBER




    // Constructor (全部欄位)
    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }


   // Getter / Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
