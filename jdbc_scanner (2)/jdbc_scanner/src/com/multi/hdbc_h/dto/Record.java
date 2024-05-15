package com.multi.hdbc_h.dto;

public class Record {
    private String user_ID;
    private int high_score;
    private int level_no;;
    private int total_score;

    public Record(){}

    public Record(String user_ID, int high_score, int level_no, int total_score) {
        this.user_ID = user_ID;
        this.high_score = high_score;
        this.level_no = level_no;
        this.total_score = total_score;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public int getHigh_score() {
        return high_score;
    }

    public void setHigh_score(int high_score) {
        this.high_score = high_score;
    }

    public int getLevel_no() {
        return level_no;
    }

    public void setLevel_no(int level_no) {
        this.level_no = level_no;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    @Override
    public String toString() {
        return "Record{" +
                "user_ID='" + user_ID + '\'' +
                ", high_score=" + high_score +
                ", level_no=" + level_no +
                ", total_score=" + total_score +
                '}';
    }
}
