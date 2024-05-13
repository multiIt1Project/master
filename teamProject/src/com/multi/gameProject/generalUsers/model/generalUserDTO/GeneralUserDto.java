package com.multi.gameProject.generalUsers.model.generalUserDTO;

import java.util.Date;

// DAO에게 값을 한꺼번에 넘겨줄 DTO 생성
public class GeneralUserDto {
	
	// 회원가입시 생성되는 데이터. 날짜 초기화
	private String user_Id;
	private String pw;
	private int coin_Count=0;
	private String name;
	private int age;
	private String tel;
	private String email;
	private Date singup_Date = new Date();
	private char del_Acc='N';
	private Date delete_Acc_Date=null;
	private String user_Pre_Id;
	
	
	// 기본 생성자
	public GeneralUserDto() {
	}
	
	// 전부 포함
	
	public GeneralUserDto(String user_Id, String pw, int coin_Count, String name, int age, String email, String tel, Date singup_Date, char del_Acc, Date delete_Acc_Date) {
		this.user_Id = user_Id;
		this.pw = pw;
		this.coin_Count = coin_Count;
		this.name = name;
		this.age = age;
		this.email = email;
		this.tel = tel;
		this.singup_Date = singup_Date;
		this.del_Acc = del_Acc;
		this.delete_Acc_Date = delete_Acc_Date;
	}
	
	
	// 가입 날짜 제외
	
	
	public GeneralUserDto(String user_Id, String pw, int coin_Count, String name, int age, String tel, String email, char del_Acc, Date delete_Acc_Date) {
		this.user_Id = user_Id;
		this.pw = pw;
		this.coin_Count = coin_Count;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.email = email;
		this.del_Acc = del_Acc;
		this.delete_Acc_Date = delete_Acc_Date;
	}
	
	// getter, setter 전부 생성
	
	
	public String getUser_Id() {
		return user_Id;
	}
	
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public int getCoin_Count() {
		return coin_Count;
	}
	
	public void setCoin_Count(int coin_Count) {
		this.coin_Count = coin_Count;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public Date getSingup_Date() {
		return singup_Date;
	}
	
	public void setSingup_Date(Date singup_Date) {
		this.singup_Date = singup_Date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public char getDel_Acc() {
		return del_Acc;
	}
	
	public void setDel_Acc(char del_Acc) {
		this.del_Acc = del_Acc;
	}
	
	public Date getDelete_Acc_Date() {
		return delete_Acc_Date;
	}
	
	public void setDelete_Acc_Date(Date delete_Acc_Date) {
		this.delete_Acc_Date = delete_Acc_Date;
	}
	
	public String getUser_Pre_Id() {
		return user_Pre_Id;
	}
	
	public void setUser_Pre_Id(String user_Pre_Id) {
		this.user_Pre_Id = user_Pre_Id;
	}
	
	@Override
	public String toString() {
		return "UserDto{" +
				"user_Id='" + user_Id + '\'' +
				", pw='" + pw + '\'' +
				", coin_Count=" + coin_Count +
				", name='" + name + '\'' +
				", age=" + age +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", singup_Date=" + singup_Date +
				", del_Acc=" + del_Acc +
				", delete_Acc_Date=" + delete_Acc_Date +
				'}';
	}
	
	
}
