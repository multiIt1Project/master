package com.multi.hdbc_h.dto;

public class Item_invt {

    private String user_ID;
    private int item_NO;
    private int item_COUNT;



    public Item_invt(){};

    public Item_invt(String user_ID, int item_NO, int item_COUNT) {
        this.user_ID = user_ID;
        this.item_NO = item_NO;
        this.item_COUNT = item_COUNT;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public int getItem_NO() {
        return item_NO;
    }

    public void setItem_NO(int item_NO) {
        this.item_NO = item_NO;
    }

    public int getItem_COUNT() {
        return item_COUNT;
    }

    public void setItem_COUNT(int item_COUNT) {
        this.item_COUNT = item_COUNT;
    }

    @Override
    public String toString() {
        return "Item_invt{" +
                "user_ID='" + user_ID + '\'' +
                ", item_NO=" + item_NO +
                ", item_COUNT=" + item_COUNT +
                '}';
    }
}
