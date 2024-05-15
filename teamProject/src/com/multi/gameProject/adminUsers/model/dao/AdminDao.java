package com.multi.miniProject.admin.model.dao;

import com.multi.miniProject.admin.model.dto.AdminDto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import static com.multi.miniProject.common.JDBCTemplate.close;


public class AdminDao {
    private Properties prop = null;

    public AdminDao() {

        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<AdminDto> selectAll(Connection conn){
        ArrayList<AdminDto> list = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            String sql = prop.getProperty("selectAll");
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            list = new ArrayList<>();

            while(rs.next()) {

                AdminDto adminDto = new AdminDto();

                adminDto.setUserId(rs.getString("USER_ID"));
                adminDto.setPassword(rs.getString("HIGH_SCORE"));
                adminDto.setUserName(rs.getString("COIN_COUNT"));
                adminDto.setTel(rs.getString("SIGNUP_DATE"));
                adminDto.setDelAcc(rs.getString("DEL_ACC"));
                adminDto.setDeleteAccDate(rs.getDate("DELETE_ACC_DATE"));

                list.add(adminDto);
            }
        } catch (SQLException e) {
            System.out.println("에러 발생");
        } finally {
            close(rs);
            close(st);
        }

        return list;
    }

    public ArrayList<AdminDto> storeManagement(Connection conn) {
        ArrayList<AdminDto> list = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            String sql = prop.getProperty("selectItem");
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            list = new ArrayList<>();

            while(rs.next()) {

                AdminDto adminDto = new AdminDto();

                adminDto.setItemNo(rs.getInt("ITEM_NO"));
                adminDto.setItemName(rs.getString("ITEM_NAME"));
                adminDto.setItemPrice(rs.getInt("ITEM_PRICE"));

                list.add(adminDto);
            }
        } catch (SQLException e) {
            System.out.println("에러 발생");
        } finally {
            close(rs);
            close(st);
        }

        return list;
    }

    public ArrayList<AdminDto> boardList(Connection conn) {
        ArrayList<AdminDto> list = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            String sql = prop.getProperty("selectBoard");
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            list = new ArrayList<>();

            while(rs.next()) {

                AdminDto adminDto = new AdminDto();

                adminDto.setNo(rs.getInt("NO"));
                adminDto.setUserId(rs.getString("USER_ID"));
                adminDto.setWriteDate(rs.getDate("WRITE_DATE"));
                adminDto.setTitle(rs.getString("TITLE"));
                adminDto.setContent(rs.getString("CONTENT"));

                list.add(adminDto);
            }
        } catch (SQLException e) {
            System.out.println("에러 발생");
        } finally {
            close(rs);
            close(st);
        }

        return list;
    }


    public int deleteUser (Connection conn, String id) {
        int result = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = prop.getProperty("deleteMember");
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            result = ps.executeUpdate();

            if(result > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            close(rs);
            close(ps);
        }


        return result;
    }

    public int deleteItem(Connection conn, String id) {
        int result = 0;
        PreparedStatement ps = null;

        try {
            String sql = prop.getProperty("deleteItem");
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            result = ps.executeUpdate();

            if(result > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }

    public int addItem(Connection conn, int itemNo, String itemName, int itemPrice) {
        int result = 0;
        PreparedStatement ps = null;

        try {
            String sql = prop.getProperty("addItem");
            ps = conn.prepareStatement(sql);

            ps.setInt(1, itemNo);
            ps.setString(2, itemName);
            ps.setInt(3, itemPrice);

            result = ps.executeUpdate();

            if(result > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;
    }
}
