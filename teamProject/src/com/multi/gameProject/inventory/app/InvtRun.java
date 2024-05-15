package com.multi.gameProject.inventory.app;

import com.multi.gameProject.generalUsers.model.dto.GeneralUserDto;
import com.multi.gameProject.inventory.view.GeneralUserStorePage;

public class InvtRun {
    public static void main(String[] args) {
        GeneralUserDto loginDto = new GeneralUserDto();
        new GeneralUserStorePage(loginDto).storeView();
//        ItemIn(vt itemInvt = new ItemInvt();
//         new CoinInvt().coinInvtView();

//        new FirstPage();
    }
}
