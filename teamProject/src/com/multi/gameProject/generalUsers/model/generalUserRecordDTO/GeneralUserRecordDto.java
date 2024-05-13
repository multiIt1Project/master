package com.multi.gameProject.generalUsers.model.generalUserRecordDTO;

public class GeneralUserRecordDto {

	// 점수 기록 테이블의 속성들
	String user_Id;
	int high_Score;
	int level_No;
	int total_Score;
	
	public GeneralUserRecordDto() {
	}
	
	public GeneralUserRecordDto(String user_Id, int high_Score, int level_No, int total_Score) {
		this.user_Id = user_Id;
		this.high_Score = high_Score;
		this.level_No = level_No;
		this.total_Score = total_Score;
	}
	
	public String getUser_Id() {
		return user_Id;
	}
	
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	
	public int getHigh_Score() {
		return high_Score;
	}
	
	public void setHigh_Score(int high_Score) {
		this.high_Score = high_Score;
	}
	
	public int getLevel_No() {
		return level_No;
	}
	
	public void setLevel_No(int level_No) {
		this.level_No = level_No;
	}
	
	public int getTotal_Score() {
		return total_Score;
	}
	
	public void setTotal_Score(int total_Score) {
		this.total_Score = total_Score;
	}
	
	@Override
	public String toString() {
		return "GeneralUserRecordDTO{" +
				"user_Id='" + user_Id + '\'' +
				", high_Score=" + high_Score +
				", level_No=" + level_No +
				", total_Score=" + total_Score +
				'}';
	}
}
