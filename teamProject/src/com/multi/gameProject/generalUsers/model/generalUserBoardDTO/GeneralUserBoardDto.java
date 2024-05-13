package com.multi.gameProject.generalUsers.model.generalUserBoardDTO;

import java.util.Date;

public class GeneralUserBoardDto {
	
	private int no;
	private String user_Id;
	private Date write_Date;
	private String title;
	private String content;
	
	public GeneralUserBoardDto() {
	}
	
	public GeneralUserBoardDto(int no, String user_Id, Date write_Date, String title, String content) {
		this.no = no;
		this.user_Id = user_Id;
		this.write_Date = write_Date;
		this.title = title;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getUser_Id() {
		return user_Id;
	}
	
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	
	public Date getWrite_Date() {
		return write_Date;
	}
	
	public void setWrite_Date(Date write_Date) {
		this.write_Date = write_Date;
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
	
	@Override
	public String toString() {
		return "BoardDto{" +
				"no=" + no +
				", user_Id='" + user_Id + '\'' +
				", write_Date=" + write_Date +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
