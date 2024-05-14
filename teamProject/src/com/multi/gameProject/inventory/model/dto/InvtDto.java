package com.multi.gameProject.inventory.model.dto;

public class InvtDto {

    private String userId;
    private int itemNo;
    private int itemCount;

    public InvtDto() {
    }

    public InvtDto(String userId, int itemNo) {
        this.userId = userId;
        this.itemNo = itemNo;
    }

    public InvtDto(String userId, int itemNo, int itemCount) {
        this.userId = userId;
        this.itemNo = itemNo;
        this.itemCount = itemCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public String toString() {
        return "InvtDto{" +
                "userId='" + userId + '\'' +
                ", itemNo=" + itemNo +
                ", itemCount=" + itemCount +
                '}';
    }
}
