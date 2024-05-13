package com.multi.gameProject.generalUsers.service;

import com.multi.gameProject.common.JDBCTemplate;
import com.multi.gameProject.generalUsers.model.generalUserDAO.GeneralUserDao;
import com.multi.gameProject.generalUsers.model.generalUserDTO.GeneralUserDto;

import javax.swing.*;
import java.sql.Connection;

public class GeneralUserService {
	
	private final GeneralUserDao generalUserDao;
	private static Connection conn = JDBCTemplate.getConnection();
	
	public GeneralUserService() {
		
		// 다오의 메서드를 쓰기위해 사용하는 다오를 미리 선언, 초기화한다.
		generalUserDao = new GeneralUserDao();
		
		// 로그인된 상태의 dto를 가지고 다니며 필요할 때 써먹는다
		GeneralUserDto loginDto;
		
	}
	
	
	public void insertUser(String userId, String pw, String name, int age, String tel, String email) {
		
		GeneralUserDto newUser = new GeneralUserDto();
		newUser.setUser_Id(userId);
		newUser.setPw(pw);
		newUser.setName(name);
		newUser.setAge(age);
		newUser.setTel(tel);
		newUser.setEmail(email);
		
		
		
		int result = generalUserDao.insertUser(newUser);
		
		if (result > 0) {
			JOptionPane.showMessageDialog(null, "회원가입 성공!!");
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패!! 아이디 중복 또는 아이디, 비번 값 미기입일 수 있으니 확인 바랍니다.");
		}
		
	}
	
	public GeneralUserDto userLogin(String userId, String userPw) {
		
		GeneralUserDto loginDto = new GeneralUserDto();
		
		loginDto = generalUserDao.userLogin(userId, userPw);
		
		if (loginDto != null) {
			// 로그인 성공 시 로그인 정보를 전역으로 선언했으므로 늘 그 정보를 이용할 수 있다.
			// 로그인은 성공하면 afterloginpage로 이동한다.
			JOptionPane.showMessageDialog(null, "로그인 성공!!");
			
		}
		
		
		return loginDto;
		
	}
	
	public int updateUser(String userId, String pw, String name, int age, String tel, String email, String user_Pre_Id) {
		
		GeneralUserDto updatedUser = new GeneralUserDto();
		
		updatedUser.setUser_Id(userId);
		updatedUser.setPw(pw);
		updatedUser.setName(name);
		updatedUser.setAge(age);
		updatedUser.setTel(tel);
		updatedUser.setEmail(email);
		updatedUser.setUser_Pre_Id(user_Pre_Id);
		
		int result = generalUserDao.updateUser(updatedUser);
		
		return result;
	}
	
	public GeneralUserDto selectUser(String userId) {
		
		GeneralUserDto generalUserDto = new GeneralUserDto();
		
		generalUserDto = generalUserDao.selectUser(userId);
		
		return generalUserDto;
		
		
		
	}
	
	public int deleteUser(String userId, String userPw) {
		
		GeneralUserDto deletedUser = new GeneralUserDto();
		
		deletedUser.setUser_Id(userId);
		deletedUser.setPw(userPw);
		
		int result = generalUserDao.deleteUser(deletedUser.getUser_Id(), deletedUser.getPw());
		
		return result;
		
		
		
	}
}
