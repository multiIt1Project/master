package com.multi.hdbc_h.dto;

public class Levels {
    private int level_no;
    private  int score;

    public Levels(){};
    public Levels(int score, int level_no) {
        super();
        this.score = score;
        this.level_no = level_no;
    }

    public int getLevel_no() {
        return level_no;
    }

    public void setLevel_no(int level_no) {
        this.level_no = level_no;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Record{" +
                "level_no=" + level_no +
                ", score=" + score +
                '}';
    }
}
