package com.multi.gameProject.generalUsers.controller;

import com.multi.gameProject.generalUsers.model.generalUserDTO.GeneralUserDto;
import com.multi.gameProject.generalUsers.service.GeneralUserService;

import javax.swing.*;

public class GeneralUserController {
	
	private GeneralUserService generalUserService = new GeneralUserService();
	
	public void insertUser(String userId, String pw, String name, int age, String tel, String email) {
	
	
		generalUserService.insertUser(userId, pw, name, age, tel, email);
		
	
	
	}
	
	public GeneralUserDto userLogin(String userId, String userPw) {
		
		GeneralUserDto loginDto= generalUserService.userLogin(userId, userPw);
		
		return loginDto;
	}
	
	public int updateUser(String userId, String pw,String name, int age, String tel, String email, String user_Pre_Id) {
		
		int result = generalUserService.updateUser(userId, pw, name, age, tel, email, user_Pre_Id);
		
		if(result>0) {
			JOptionPane.showMessageDialog(null, "회원정보 변경 성공!!");
			
		}else {
			JOptionPane.showMessageDialog(null, "회원정보 변경 실패!!");
		}
		
		return result;
		
		
	}
	
	public GeneralUserDto selectUser(String userId) {
		
		GeneralUserDto selectUser = generalUserService.selectUser(userId);
		
		return selectUser;
		
		
	}
	
	public int deleteUser(String userId, String userPw) {
		
		int result = generalUserService.deleteUser(userId, userPw);
		
		if(result>0) {
			JOptionPane.showMessageDialog(null, "회원 삭제 성공!!");
			
		}else {
			JOptionPane.showMessageDialog(null, "회원 삭제 실패!!");
		}
		
		return result;
	}
	
	
	
}
