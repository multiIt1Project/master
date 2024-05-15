package com.multi.gameProject.inventory.model.dao;

import com.multi.gameProject.common.InvtException;
import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.model.dto.ItemDto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.multi.gameProject.common.JDBCTemplate.close;

public class InvtDao {

    private Properties prop = null;

    public InvtDao() {

        try {
            prop = new Properties();
            prop.load(new FileReader("resources/invtquery.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getUserCoin(Connection conn, String userId) throws InvtException {
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
            throw new InvtException("getUserCoin 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }

        return coin;
    }

    public int getUserScore(Connection conn, String userId) throws InvtException {
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
            throw new InvtException("getUserScore 에러 : " + e.getMessage());

        } finally {
            close(rs);
            close(ps);
        }
        return score;
    }

    public int changeScore(Connection conn, String userId, int score) throws InvtException {
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
            throw new InvtException("changeScore 에러 : " + e.getMessage());
        } finally {
            close(ps);
        }

        return result;
    }

    public int changeCoin(Connection conn, String userId, int price) throws InvtException {
        int result = 0;

        PreparedStatement ps = null;
        String sql = prop.getProperty("changeCoin");
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, price);
            ps.setString(2, userId);
            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvtException("changeCoin 에러 : " + e.getMessage());
        } finally {
            close(ps);
        }

        return result;
    }

    public int getItemPrice(Connection conn, int itemNo) throws InvtException {
        int price = 0;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = prop.getProperty("getItemPrice");

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                price = rs.getInt("ITEM_PRICE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvtException("getItemPrice 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }

        return price;
    }

    public ArrayList<ItemDto> getItems(Connection conn) throws InvtException {
        ArrayList<ItemDto> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = prop.getProperty("getItems");

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                ItemDto itemDto = new ItemDto();
                itemDto.setItemNo(rs.getInt("ITEM_NO"));
                itemDto.setItemName(rs.getString("ITEM_NAME"));
                itemDto.setItemPrice(rs.getInt("ITEM_PRICE"));

                list.add(itemDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvtException("getItems 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return list;

    }

    public InvtDto getUserInvt(Connection conn, InvtDto invtDto) throws InvtException {

        InvtDto rsDto = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = prop.getProperty("getUserInvt");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, invtDto.getUserId());
            ps.setInt(2, invtDto.getItemNo());
            rs = ps.executeQuery();

            if (rs.next()) {
                rsDto = new InvtDto();
                rsDto.setUserId(rs.getString("USER_ID"));
                rsDto.setItemNo(rs.getInt("ITEM_NO"));
                rsDto.setItemCount(rs.getInt("ITEM_COUNT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvtException("getUserInvt 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }

        return rsDto;
    }

    public int insertInvt(Connection conn, InvtDto invtDto) {
        int result = 0;

        PreparedStatement ps = null;
        String sql = prop.getProperty("insertInvt");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, invtDto.getUserId());
            ps.setInt(2, invtDto.getItemNo());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }

    public int updateInvt(Connection conn, InvtDto invtDto) {
        int result = 0;

        PreparedStatement ps = null;
        String sql = prop.getProperty("updateInvt");

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, invtDto.getUserId());
            ps.setInt(2, invtDto.getItemNo());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
        }

        return result;
    }
}
