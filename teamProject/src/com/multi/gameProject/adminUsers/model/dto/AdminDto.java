package com.multi.gameProject.adminUsers.model.dto;

import java.sql.Date;

public class AdminDto {

    private static final long serialVersionUID = 2304690199893905221L;

    private String userId;
    private String password;
    private String userName;
    private int age;
    private String tel;
    private String email;
    private Date SignUpDate;
    private String delAcc;
    private Date deleteAccDate;

    private int itemNo;
    private String itemName;
    private int itemPrice;

    private int No;
    private Date writeDate;
    private String title;
    private String content;

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSignUpDate() {
        return SignUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        SignUpDate = signUpDate;
    }

    public String getDelAcc() {
        return delAcc;
    }

    public void setDelAcc(String delAcc) {
        this.delAcc = delAcc;
    }

    public Date getDeleteAccDate() {
        return deleteAccDate;
    }

    public void setDeleteAccDate(Date deleteAccDate) {
        this.deleteAccDate = deleteAccDate;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", SignUpDate=" + SignUpDate +
                ", delAcc='" + delAcc + '\'' +
                ", deleteAccDate=" + deleteAccDate +
                '}';
    }
}
