package com.multi.gameProject.inventory.service;

import com.multi.gameProject.inventory.model.dao.InvtDao;

import java.sql.Connection;

import static com.multi.gameProject.common.JDBCTemplate.*;

public class InvtService {


    private InvtDao invtDao;

    public InvtService() {
        invtDao = new InvtDao();
    }

    public int getMyCoin(String userId) {

        int coin = 0;

        Connection conn = getConnection();
        coin = invtDao.getMyCoin(conn, userId);

        return coin;
    }

    public int getMyScore(String userId) {

        int score = 0;

        Connection conn = getConnection();
        score = invtDao.getMyScore(conn, userId);

        return score;
    }

    public int changeScoreToCoin(String userId, int inputScore) {

        int result = 0;
        int score = inputScore;
        int coin = inputScore/100;
        Connection conn = getConnection();
        int result1 = invtDao.changeScore(conn, userId, score);
        int result2 = invtDao.changeCoin(conn, userId, coin);

        if (result1 > 0 && result2 > 0) {
            commit(conn);
            result = 1;
        } else {
            rollback(conn);
        }

        return result;
    }
}
