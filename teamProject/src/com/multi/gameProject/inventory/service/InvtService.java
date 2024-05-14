package com.multi.gameProject.inventory.service;

import com.multi.gameProject.inventory.model.dao.InvtDao;
import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.model.dto.ItemDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.multi.gameProject.common.JDBCTemplate.*;

public class InvtService {

    private InvtDao invtDao;

    public InvtService() {
        invtDao = new InvtDao();
    }

    public int getUserCoin(String userId) {
        Connection conn = getConnection();
        int coin = invtDao.getUserCoin(conn, userId);

        return coin;
    }

    public int getUserScore(String userId) {
        Connection conn = getConnection();
        int score = invtDao.getUserScore(conn, userId);

        return score;
    }

    public int changeScoreToCoin(String userId, int inputScore) {
        Connection conn = getConnection();
        int result = 0;
        int score = inputScore;
        int coin = inputScore/100;
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

    public int getItemPrice(int itemNo) {
        Connection conn = getConnection();

        int price = invtDao.getItemPrice(conn, itemNo);

        return price;
    }

    public ArrayList<ItemDto> getItems() {
        Connection conn = getConnection();

        ArrayList<ItemDto> list = invtDao.getItems(conn);

        return list;
    }

    public int getUserItemCount(InvtDto invtDto) {
        Connection conn = getConnection();
        int count = 0;
        InvtDto userInvt = invtDao.getUserInvt(conn, invtDto);

        if(userInvt != null){
            count = userInvt.getItemCount();
        }

        return count;

    }

    public int buyItem(InvtDto invtDto) {
        int result = 0;
        int result1;
        int result2;
        Connection conn = getConnection();
        String userId = invtDto.getUserId();
        int itemNo = invtDto.getItemNo();
        int coin = getItemPrice(itemNo);

        // 기존 인벤토리 존재 여부 확인
        InvtDto userInvt = invtDao.getUserInvt(conn, invtDto);

        if(userInvt == null){
            result1 = invtDao.insertInvt(conn, invtDto);
            result2 = invtDao.changeCoin(conn, userId, -coin);
        } else{
            result1 = invtDao.updateInvt(conn, invtDto);
            result2 = invtDao.changeCoin(conn, userId, -coin);
        }

        if (result1 > 0 && result2 > 0) {
            commit(conn);
            result = 1;
        } else {
            rollback(conn);
        }

        return result;
    }
}
