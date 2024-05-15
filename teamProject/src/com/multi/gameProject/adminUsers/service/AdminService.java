package com.multi.gameProject.adminUsers.service;

import com.multi.gameProject.adminUsers.model.dao.AdminDao;
import com.multi.gameProject.adminUsers.model.dto.AdminDto;

import java.sql.Connection;
import java.util.ArrayList;

import static com.multi.gameProject.common.JDBCTemplate.*;

public class AdminService {
    private final AdminDao adminDao;

    public AdminService() {
        adminDao = new AdminDao();
    }

    public ArrayList<AdminDto> selectAll() {
        Connection conn = getConnection();
        ArrayList<AdminDto> list = adminDao.selectAll(conn);

        return list;
    }

    public ArrayList<AdminDto> storeManagement() {
        Connection conn = getConnection();
        ArrayList<AdminDto> list = adminDao.storeManagement(conn);

        return list;
    }

    public ArrayList<AdminDto> boardList() {
        Connection conn = getConnection();
        ArrayList<AdminDto> list = adminDao.boardList(conn);

        return list;
    }

    public int deleteUser(String id) {
        Connection conn = getConnection();
        int result = adminDao.deleteUser(conn, id);

        if (result > 0) commit(conn);
        else rollback(conn);

        return result;
    }

    public int deleteItem(String id) {
        Connection conn = getConnection();
        int result = adminDao.deleteItem(conn, id);

        if (result > 0) commit(conn);
        else rollback(conn);

        return result;
    }

    public int deleteBoard(String no) {
        Connection conn = getConnection();
        int result = adminDao.deleteBoard(conn, no);

        if (result > 0) commit(conn);
        else rollback(conn);

        return result;
    }


    public void addItem(int itemNo, String itemName, int itemPrice) {
        Connection conn = getConnection();

        int result = adminDao.addItem(conn, itemNo, itemName, itemPrice);

        if (result > 0) commit(conn);
        else rollback(conn);
    }

    public ArrayList<AdminDto> rankingList() {
        Connection conn = getConnection();
        ArrayList<AdminDto> list = adminDao.rankingList(conn);

        return list;
    }
}
