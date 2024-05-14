package com.multi.gameProject.inventory.model.dto;

public class ItemDto {
    private int itemNo;
    private String itemName;
    private int itemPrice;
    private String img;

    public ItemDto() {
    }

    public ItemDto(int itemNo, String itemName, int itemPrice) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getImg() {
        return img;
    }

    private void setImg() {
        if (itemNo == 1) {
            img = "double.png";
        } else if (itemNo == 2) {
            img = "time.png";
        } else if (itemNo == 3) {
            img = "pass.png";
        }
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
        setImg();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
