package com.multi.gameProject.adminUsers.controller;

import com.multi.gameProject.adminUsers.model.dto.AdminDto;
import com.multi.gameProject.adminUsers.service.AdminService;
import com.multi.gameProject.adminUsers.view.BoardList;
import com.multi.gameProject.adminUsers.view.ItemManagement;
import com.multi.gameProject.adminUsers.view.MemberList;

import java.util.ArrayList;

public class AdminController {
    private AdminService adminService = new AdminService();

    public void selectAll() {

        MemberList memberList = new MemberList();
        ArrayList<AdminDto> list;

        try {
            list = adminService.selectAll();

            if (!list.isEmpty()){
                memberList.selectList();
            } else {
                memberList.displayNoData();
            }
        } catch (Exception e) {
            memberList.displayError("회원 전체 조회 실패, 관리자에 문의하세요. ");
            e.printStackTrace();
        }
    }

    public void storeManagement() {
        ItemManagement itemManagement = new ItemManagement();
        ArrayList<AdminDto> list;

        list = adminService.storeManagement();

        if (!list.isEmpty()) {
            itemManagement.ItemPageView();
        } else {
            itemManagement.ItemPageView();
        }
    }

    public void boardManagement() {
        BoardList boardList = new BoardList();
        ArrayList<AdminDto> list;

        list = adminService.boardList();

        if (!list.isEmpty()) {
            boardList.BoardView();
        } else {
            boardList.BoardView();
        }
    }

    public void addItem(int itemNo, String itemName, int itemPrice) {
        adminService.addItem(itemNo, itemName, itemPrice);
    }
}
