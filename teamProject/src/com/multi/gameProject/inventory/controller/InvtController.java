package com.multi.gameProject.inventory.controller;

import com.multi.gameProject.inventory.model.dao.InvtDao;
import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.service.InvtService;
import com.multi.gameProject.inventory.view.CoinInvt;
import com.multi.gameProject.inventory.view.Store;

import java.util.ArrayList;

public class InvtController {

    private Store store;
    private InvtService invtService = new InvtService();

    public int getUserCoin(String userId) {
        int coin = invtService.getMyCoin(userId);

        return coin;
    }

    public int getUserScore(String userId) {
        int score = invtService.getMyScore(userId);

        // 레코드에서 가져오기
//        score = invtDao.getMyScore(id);

        return score;
    }

    public int getOutputCoin(String userId, int inputScore) {
        int outputCoin = 0;
        CoinInvt coinInvt = new CoinInvt();

        if (inputScore <= getUserScore(userId)) {
            if (inputScore % 100 != 0) {
                coinInvt.showDialog("100의 배수로 입력해주세요.");

            } else {
                outputCoin = inputScore / 100;
            }
        } else {
            coinInvt.showDialog("점수가 부족합니다.");
        }

        return outputCoin;
    }

    public int changeScoreToCoin(String userId, int inputScore) {
        int result = 0;

        int finalInput = getOutputCoin(userId, inputScore);

        if(finalInput != 0){
            result = invtService.changeScoreToCoin(userId, inputScore);

        }

        return result;
    }


    public ArrayList<InvtDao> getMyItems(String userId) {

        ArrayList<InvtDao> list = null;

        return list;
    }

    public int buyItem(InvtDto invtDto) {
        int result = 0;
        String userId = invtDto.getUserId();




        return result;
    }
}
