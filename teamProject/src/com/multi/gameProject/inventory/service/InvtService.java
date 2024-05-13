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

        Connection conn = getConnection();
        result = invtDao.changeScoreToCoin(conn, userId, inputScore);

        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        return result;
    }
}
