package com.multi.gameProject.generalUsers.controller;

import com.multi.gameProject.adminUsers.view.AdminView;
import com.multi.gameProject.generalUsers.model.dto.GeneralUserDto;
import com.multi.gameProject.generalUsers.service.GeneralUserService;
import com.multi.gameProject.generalUsers.view.GeneralUserAfterLoginHomePage;
import com.multi.gameProject.generalUsers.view.GeneralUserBeforeLoginPage;

import javax.swing.*;

public class GeneralUserController {
	
	private GeneralUserService generalUserService = new GeneralUserService();
	
	public void insertUser(String userId, String pw, String name, int age, String tel, String email) {
		
		
		try {
			GeneralUserDto newUser = new GeneralUserDto();
			newUser.setUser_Id(userId);
			newUser.setPw(pw);
			newUser.setName(name);
			newUser.setAge(age);
			newUser.setTel(tel);
			newUser.setEmail(email);
			
			
			int result = generalUserService.insertUser(newUser);
			
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "회원가입 성공!!");
			} else {
				JOptionPane.showMessageDialog(null, "회원가입 실패!! 참고로 나이는 3자리까지 가능합니다.");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "회원가입 실패!!" + e.getMessage());
		}
		
		
	}
	
	///////////
	public GeneralUserDto userLogin(JFrame f, JTextArea textArea, String userId, String userPw) {
		
		GeneralUserDto loginDto = null;
		
		try {
			loginDto = generalUserService.userLogin(userId, userPw);
			
			if (loginDto != null) {
				// 로그인 성공 시 로그인 정보인 loginDto를 전역으로 선언했으므로 늘 그 정보를 이용할 수 있다.
				// 로그인은 성공하면 afterloginpage로 이동한다.
				
				System.out.println(loginDto);
				JOptionPane.showMessageDialog(null, loginDto);
				
				if (loginDto.getUser_Id().length() >= 5) {
					if (loginDto.getUser_Id().substring(0, 5).equals("ADMIN")) {
						// 관리자 페이지 연결
						AdminView adminView = new AdminView(loginDto);
						
						
						
					}
					
				} else {
					GeneralUserAfterLoginHomePage home = new GeneralUserAfterLoginHomePage(loginDto);
				}
				
				
				f.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패!!");
				textArea.setText("아이디가 존재하지 않거나 비밀번호가 틀립니다!!");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		return loginDto;
	}
	
	public int updateUser(String userId, String pw, String name, int age, String tel, String email, String user_Pre_Id) {
		
		
		GeneralUserDto user = new GeneralUserDto();
		user.setUser_Id(userId);
		user.setPw(pw);
		user.setName(name);
		user.setAge(age);
		user.setTel(tel);
		user.setEmail(email);
		user.setUser_Pre_Id(user_Pre_Id);
		
		int result = 0;
		try {
			result = generalUserService.updateUser(user);
			
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "회원정보 변경 성공!!");
				
			} else {
				JOptionPane.showMessageDialog(null, "회원정보 변경 실패??!!");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "회원정보 변경 실패!!" + e.getMessage());
			
		}
		
		
		return result;
		
		
	}
	
	public GeneralUserDto selectUser(String userId) {
		
		GeneralUserDto selectUser = generalUserService.selectUser(userId);
		
		return selectUser;
		
		
	}
	
	public int deleteUser(GeneralUserDto loginDto) {
		
		String userId = loginDto.getUser_Id();
		String userPw = loginDto.getPw();
		
		int result = 0;
		try {
			result = generalUserService.deleteUser(userId, userPw);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "회원 삭제 성공!! 초기화면으로 돌아갑니다.");
				GeneralUserBeforeLoginPage home = new GeneralUserBeforeLoginPage();
			} else {
				JOptionPane.showMessageDialog(null, "회원 삭제 실패!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "회원 삭제 실패!!" + e.getMessage());
		}
		
		
		return result;
	}
	
	
}
