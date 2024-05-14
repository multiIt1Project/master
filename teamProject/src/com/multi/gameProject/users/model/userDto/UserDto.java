package com.multi.gameProject.users.model.userDto;

import java.util.Date;

// DAO에게 값을 한꺼번에 넘겨줄 DTO 생성
public class UserDto {
	
	// 회원가입시 생성되는 데이터. 날짜 초기화
	private String Id;
	private String Pw;
	private String name;
	private int age;
	private String email;
	private String tel;
	private Date createDate = new Date();
	
	// 상점에서 사용할 코인, 아이템 5가지 종류. null 방지를 위해 0으로 초기화
	private int coin=0;
	private int itemA=0;
	private int itemB=0;
	private int itemC=0;
	private int itemD=0;
	private int itemE=0;
	
	// 기본 생성자
	public UserDto() {
	}
	
	// 날짜, 아이템 전부 포함
	
	public UserDto(String id, String pw, String name, int age, String email, Date createDate, int coin, int itemA, int itemB, int itemC, int itemD, int itemE) {
		Id = id;
		Pw = pw;
		this.name = name;
		this.age = age;
		this.email = email;
		this.createDate = createDate;
		this.coin = coin;
		this.itemA = itemA;
		this.itemB = itemB;
		this.itemC = itemC;
		this.itemD = itemD;
		this.itemE = itemE;
	}
	
	
	// 날짜 제외
	
	public UserDto(String id, String pw, String name, int age, String email, int coin, int itemA, int itemB, int itemC, int itemD, int itemE) {
		Id = id;
		Pw = pw;
		this.name = name;
		this.age = age;
		this.email = email;
		this.coin = coin;
		this.itemA = itemA;
		this.itemB = itemB;
		this.itemC = itemC;
		this.itemD = itemD;
		this.itemE = itemE;
	}
	
	
	
	// getter, setter 전부 생성
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}
	
	public String getPw() {
		return Pw;
	}
	
	public void setPw(String pw) {
		Pw = pw;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getCoin() {
		return coin;
	}
	
	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	public int getItemA() {
		return itemA;
	}
	
	public void setItemA(int itemA) {
		this.itemA = itemA;
	}
	
	public int getItemB() {
		return itemB;
	}
	
	public void setItemB(int itemB) {
		this.itemB = itemB;
	}
	
	public int getItemC() {
		return itemC;
	}
	
	public void setItemC(int itemC) {
		this.itemC = itemC;
	}
	
	public int getItemD() {
		return itemD;
	}
	
	public void setItemD(int itemD) {
		this.itemD = itemD;
	}
	
	public int getItemE() {
		return itemE;
	}
	
	public void setItemE(int itemE) {
		this.itemE = itemE;
	}
	
	@Override
	public String toString() {
		return "UserDto{" +
				"Id='" + Id + '\'' +
				", Pw='" + Pw + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				", createDate=" + createDate +
				", coin=" + coin +
				", itemA=" + itemA +
				", itemB=" + itemB +
				", itemC=" + itemC +
				", itemD=" + itemD +
				", itemE=" + itemE +
				'}';
	}
}
