package com.multi.gameProject.inventory.model.dao;

import com.multi.gameProject.inventory.model.dto.InvtDto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.multi.gameProject.common.JDBCTemplate.close;

public class InvtDao {

    private Properties prop = null;

    public InvtDao() {

        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int buyItem(InvtDto invtDto) {
        int result = 0;

        PreparedStatement ps = null;

        // 기존 인벤토리 존재 여부 확인
        InvtDto invt = getInvt(invtDto.getUserId(), invtDto.getItemNo());


        return result;


    }

    private InvtDto getInvt(String userId, int itemNo) {
        // 기존 인벤토리 있으면 기존 인벤토리 반환, 없으면 새로운 인벤토리 생성 후 반환
        InvtDto resultInvt = null;
        PreparedStatement ps = null;


        return resultInvt;
    }


    public int buyItem(int itemNo) {
        int result = 0;

        PreparedStatement ps = null;


        return result;


    }


    public int getMyCoin(Connection conn, String userId) {
        int coin = 0;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = prop.getProperty("getUserCoin");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                coin = rs.getInt("COIN_COUNT");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
        }

        return coin;
    }

    public int getMyScore(Connection conn, String userId) {
        int score = 0;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = prop.getProperty("getUserScore");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();

            if (rs.next()) {
                score = rs.getInt("TOTAL_SCORE");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(ps);
        }


        return score;
    }

    public int changeScore(Connection conn, String userId, int score) {
        int result = 0;

        PreparedStatement ps = null;
        String sql = prop.getProperty("changeScore");

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, score);
            ps.setString(2, userId);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public int changeCoin(Connection conn, String userId, int coin) {
        int result = 0;

        PreparedStatement ps = null;
        String sql = prop.getProperty("changeCoin");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, coin);
            ps.setString(2, userId);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }
}
