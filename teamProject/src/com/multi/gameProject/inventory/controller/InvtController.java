package com.multi.gameProject.inventory.controller;

import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.model.dto.ItemDto;
import com.multi.gameProject.inventory.service.InvtService;
import com.multi.gameProject.inventory.view.CoinInvt;
import com.multi.gameProject.inventory.view.Store;

import java.util.ArrayList;

public class InvtController {

    private Store store;
    private InvtService invtService = new InvtService();

    public int getUserCoin(String userId) {
        int coin = invtService.getUserCoin(userId);

        return coin;
    }

    public int getUserScore(String userId) {
        int score = invtService.getUserScore(userId);

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

    public int buyItem(InvtDto invtDto) {
        int result = invtService.buyItem(invtDto);

        return result;
    }

    public int getItemPrice(int itemNo) {

        int price = invtService.getItemPrice(itemNo);

        return price;
    }

    public ArrayList<ItemDto> getItems() {
        ArrayList<ItemDto> list = null;
        list = invtService.getItems();

        return list;
    }

    public int getUserItemCount(InvtDto invtDto) {
        int itemCount = invtService.getUserItemCount(invtDto);

        return itemCount;

    }
}
