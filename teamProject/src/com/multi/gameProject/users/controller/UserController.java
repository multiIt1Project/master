package com.multi.gameProject.users.controller;

import com.multi.gameProject.users.view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
	
	// 유저 뷰 받음
	private UserView userView;
	
	// 유저 뷰의 버튼, 텍스트 필드 받음
	private static JTextField idField1;
	private static JPasswordField pwField1;
	private static JButton loginButton;
	
	private static JButton logOutButton;
	
	private static JTextField idField2;
	private static JPasswordField pwField2;
	private static JTextField nameField;
	private static JTextField ageField;
	private static JTextField telField;
	private static JTextField emailField;
	private static JButton signUpButton;
	
	private static JButton deleteButton;
	
	
	// 뷰로 받은 데이터를 추출
	private static String loginId;
	private static String loginPw;
	
	private static String logoutId;
	
	private static String signUpId;
	private static String signUpPw;
	private static String signUpName;
	private static int signUpAge;
	private static String signUpTel;
	private static String signUpEmail;
	
	private static String deleteId;
	
	
	// 뷰의 이벤트를 처리해 DTO에게 값을 넘겨줄 사용자 컨트롤러
	public void userController() {
		
		// userView 생성
		userView = new UserView();
		userView.viewFrame();
		
		
		// 버튼 이벤트 생성
		loginbtnEvent();
		logoutbtnEvent();
		signupbtnEvent();
		deletebtnEvent();
		
		
	}
	
	
	// 뷰의 버튼 이벤트
	
	// 버튼 이벤트
	
	public void loginbtnEvent() {
		
		// 로그인 버튼 가져옴
		loginButton = userView.getLoginButton();
		idField1 = userView.getIdField1();
		pwField1 = userView.getPwField1();
		
		// 로그인 버튼 이벤트 :  아이디, 비번 추출
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 아이디, 비번 추출
				loginId = idField1.getText();
				loginPw = pwField1.getText();
				
				//콘솔로 확인
				System.out.println();
				System.out.println(loginId);
				System.out.println(loginPw);
				
				
				
				// 로그인 dao
				
				
				// 텍스트필드 초기화
				idField1.setText("");
				pwField1.setText("");
				
				
			}
		});
		
		
	}
	
	
	public void logoutbtnEvent() {
		
		// 로그아웃 버튼 가져옴
		logOutButton = userView.getLogOutButton();
		logoutId = loginId;
		
		// 로그아웃 버튼 이벤트 :  로그아웃
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 아이디, 비번 추출
				logoutId = loginId;
				
				// 콘솔로 확인
				System.out.println();
				System.out.println(logoutId);
				
				// 로그아웃 다오
				
				
				
				// 초기 유저뷰 페이지로 돌아감
				
			}
		});
		
		
	}
	
	
	public void signupbtnEvent() {
		
		//회원가입 버튼 가져옴
		signUpButton = userView.getSignUpButton();
		idField2 = userView.getIdField2();
		pwField2 = userView.getPwField2();
		nameField = userView.getNameField();
		ageField = userView.getAgeField();
		telField = userView.getTelField();
		emailField = userView.getEmailField();
		
		// 회원가입 버튼 이벤트 :  아이디, 비번, 나이, 이메일 추출
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 아이디, 비번 추출
				
				signUpId = idField2.getText();
				signUpPw = pwField2.getText();
				signUpName = nameField.getText();
				signUpAge = Integer.parseInt(ageField.getText());
				signUpTel = telField.getText();
				signUpEmail = emailField.getText();
				
				// 콘솔로 확인
				System.out.println();
				System.out.println(signUpId);
				System.out.println(signUpPw);
				System.out.println(signUpName);
				System.out.println(signUpAge);
				System.out.println(signUpTel);
				System.out.println(signUpEmail);
				
				
				// 회원가입 다오
				
				
				// 텍스트 필드 초기화
				idField2.setText("");
				pwField2.setText("");
				nameField.setText("");
				ageField.setText("");
				telField.setText("");
				emailField.setText("");
				
				
			}
		});
	}
	
	
	public void deletebtnEvent() {
		
		// 로그아웃 버튼 가져옴
		deleteButton = userView.getDeleteButton();
		deleteId = loginId;
		
		// 로그아웃 버튼 이벤트 :  로그아웃
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 초기 유저뷰 페이지로 돌아감, 데이터 삭제
				deleteId = loginId;
				
				// 콘솔로 확인
				System.out.println();
				System.out.println(deleteId);
				
				
				// 삭제 다오
				
				
			}
		});
	}
	
	
}
