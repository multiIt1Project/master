package com.multi.hdbc_h.controller;

import com.multi.hdbc_h.dto.Record;
import com.multi.hdbc_h.service.UsersService;
import com.multi.jdbc.common.exception.MemberException;
import com.multi.jdbc.member.view.MemberMenu;

public class UsersController {

    private UsersService usersService = new UsersService();

    public int selectlevel(int level) {
        MemberMenu menu = new MemberMenu();

        int num=0;
        try {
            num = usersService.selectlevel(level);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
            menu.displayError("회원전체 조회 실패, 관리자에 문의하세요 ");

        }
        return num;
    }
    public Record selectHIGH_SCORE(String id) {
        MemberMenu menu = new MemberMenu();
        Record record=null;
        int num=0;
        try {
            record = usersService.selectHIGH_SCORE(id);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
            menu.displayError("회원전체 조회 실패, 관리자에 문의하세요 ");

        }
        return record;
    }
    public int selectItem(String id, int item_NO) {
        MemberMenu menu = new MemberMenu();

        int num=0;
        try {
            num = usersService.selectItem(id,item_NO);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
            menu.displayError("회원 아이템 조회 실패, 관리자에 문의하세요 ");

        }
        return num;
    }





    public void updateHIGH_SCORE(Record member) {

        int result = 0;
        try {
            result = usersService.updateHIGH_SCORE(member);
            if( result > 0 ){
                new MemberMenu().displaySuccess("최고점수수정 성공");
            }
        } catch (MemberException e) {
            e.printStackTrace();
            new MemberMenu().displayError("회원수정실패, 관리자에 문의하세요 ");
        }
    }
    public void updateItem(String id,int item_NO,int item_count) {

        int result = 0;
        try {
            result = usersService.updateItem(id,item_NO,item_count);
            if( result > 0 ){
                new MemberMenu().displaySuccess("최고점수수정 성공");
            }
        } catch (MemberException e) {
            e.printStackTrace();
            new MemberMenu().displayError("회원수정실패, 관리자에 문의하세요 ");
        }
    }


    }
