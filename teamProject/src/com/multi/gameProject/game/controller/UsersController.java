package com.multi.gameProject.game.controller;

import com.multi.gameProject.common.MemberException;
import com.multi.gameProject.game.model.dto.Recorduser;
import com.multi.gameProject.game.service.UsersService;


public class UsersController {

    private UsersService usersService = new UsersService();

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
    public Recorduser selectHIGH_SCORE(String id) {

        Recorduser record=null;
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





    public void updateHIGH_SCORE(Recorduser member) {

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
