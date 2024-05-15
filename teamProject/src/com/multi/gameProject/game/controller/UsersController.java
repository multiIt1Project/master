package com.multi.gameProject.game.controller;

import com.multi.hdbc_h.dto.Record;

public class UsersController {

    private com.multi.hdbc_h.service.UsersService usersService = new com.multi.hdbc_h.service.UsersService();

    public int selectlevel(int level) {


        int num=0;
        try {
            num = usersService.selectlevel(level);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();


        }
        return num;
    }
    public Record selectHIGH_SCORE(String id) {

        Record record=null;
        int num=0;
        try {
            record = usersService.selectHIGH_SCORE(id);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();


        }
        return record;
    }
    public int selectItem(String id, int item_NO) {

        int num=0;
        try {
            num = usersService.selectItem(id,item_NO);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return num;
    }





    public void updateHIGH_SCORE(Record member) {

        int result = 0;
        try {
            result = usersService.updateHIGH_SCORE(member);
            if( result > 0 ){

            }
        } catch (MemberException e) {
            e.printStackTrace();

        }
    }
    public void updateItem(String id,int item_NO,int item_count) {

        int result = 0;
        try {
            result = usersService.updateItem(id,item_NO,item_count);
            if( result > 0 ){

            }
        } catch (MemberException e) {
            e.printStackTrace();

        }
    }


    }
