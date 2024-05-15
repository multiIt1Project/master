package com.multi.gameProject.inventory.controller;

import com.multi.gameProject.common.InvtException;
import com.multi.gameProject.inventory.model.dto.InvtDto;
import com.multi.gameProject.inventory.model.dto.ItemDto;
import com.multi.gameProject.inventory.service.InvtService;

import javax.swing.*;
import java.util.ArrayList;

public class InvtController {

    private InvtService invtService = new InvtService();

    public int getUserCoin(String userId) {

        int coin = 0;
        try {
            coin = invtService.getUserCoin(userId);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"코인 조회 실패, 관리자에 문의하세요 ");
            e.printStackTrace();
        }
        return coin;
    }

    public int getUserScore(String userId) {

        int score = 0;
        try {
            score = invtService.getUserScore(userId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"점수 조회 실패, 관리자에 문의하세요 ");
            e.printStackTrace();
        }

        return score;
    }

    public int getOutputCoin(String userId, int inputScore) {
        int outputCoin = 0;

        if (inputScore <= getUserScore(userId)) {
            if (inputScore % 100 != 0) {
                JOptionPane.showMessageDialog(null,"100의 배수로 입력해주세요.");

            } else {
                outputCoin = inputScore / 100;
            }
        } else {
            JOptionPane.showMessageDialog(null,"점수가 부족합니다.");
        }

        return outputCoin;
    }

    public int changeScoreToCoin(String userId, int inputScore) {
        int result = 0;

        int finalInput = getOutputCoin(userId, inputScore);

        if (finalInput != 0) {
            try {
                result = invtService.changeScoreToCoin(userId, inputScore);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"변환 실패, 관리자에 문의하세요 ");
                e.printStackTrace();
            }

        }

        return result;
    }

    public int buyItem(InvtDto invtDto) {
        int result = 0;
        try {
            if (invtService.getUserCoin(invtDto.getUserId()) < invtService.getItemPrice(invtDto.getItemNo())) {
                JOptionPane.showMessageDialog(null,"코인이 부족합니다. ");
            } else {
                result = invtService.buyItem(invtDto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"아이템 구입 실패, 관리자에 문의하세요 ");
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<ItemDto> getItems() {
        ArrayList<ItemDto> list = null;
        try {
            list = invtService.getItems();
        } catch (InvtException e) {
            JOptionPane.showMessageDialog(null,"아이템 불러오기 실패, 관리자에 문의하세요 ");
            e.printStackTrace();
        }

        return list;
    }

    public int getUserItemCount(InvtDto invtDto) {
        int itemCount = 0;
        try {
            itemCount = invtService.getUserItemCount(invtDto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"아이템 조회 실패, 관리자에 문의하세요 ");
            e.printStackTrace();
        }

        return itemCount;

    }
}
