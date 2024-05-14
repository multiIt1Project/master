package com.multi.gameProject.users.view;

import javax.swing.*;
import java.awt.*;

// gui 예쁘게 수정 필요!!!
public class UserView {
	
	private static JFrame f;
	
	private static JPanel logInPanel;
	private static JTextField idField1;
	private static JPasswordField pwField1;
	private static JButton loginButton;
	
	private static JPanel logOutPanel;
	private static JButton logOutButton;
	
	private static JPanel signUpPanel;
	private static JTextField idField2;
	private static JPasswordField pwField2;
	private static JTextField nameField;
	private static JTextField ageField;
	private static JTextField telField;
	private static JTextField emailField;
	private static JButton signUpButton;
	
	private static JPanel deleteAccPanel;
	private static JButton deleteButton;
	
	
	
	// 유저가 보는 뷰를 생성
	public void viewFrame() {
		
		f = new JFrame("유저 뷰");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 1000);
		
		viewLogin();
		viewLogOut();
		viewSignUp();
		viewDelete();
		
		
		// 가장 큰 패널 생성. 로그인/로그아웃/회원가입/회원탈퇴 패널 포함
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(logInPanel);
		panel.add(logOutPanel);
		panel.add(signUpPanel);
		panel.add(deleteAccPanel);
		
		// 전체 프레임에 추가
		f.add(panel);
		f.setVisible(true);
		
		
	}
	
	
	public void viewLogin() {
		
		// 1. 로그인 창
		
		// 1-1. 로그인 전체 패널
		logInPanel = new JPanel();
		logInPanel.setLayout(new FlowLayout());
		logInPanel.add(new JLabel("로그인"));
		
		// 로그인 - 아이디
		logInPanel.add(new JLabel("ID"));
		idField1 = new JTextField(10);
		logInPanel.add(idField1);
		
		// 로그인 - 패스워드
		logInPanel.add(new JLabel("PW"));
		pwField1 = new JPasswordField(10);
		logInPanel.add(pwField1);
		
		// 1-2. 로그인 버튼 생성
		loginButton = new JButton("Log in");
		logInPanel.add(loginButton);
		
		
		
	}
	
	public void viewLogOut() {
		
		// 2. 로그아웃 창
		
		// 2-1. 로그아웃 전체 패널
		logOutPanel = new JPanel();
		logOutPanel.setLayout(new FlowLayout());
		logOutPanel.add(new JLabel("로그아웃"));
		
		// 2-2. 로그아웃 버튼 생성
		logOutButton = new JButton("Log out");
		logOutPanel.add(logOutButton);
		
		
	}
	
	
	public void viewSignUp() {
		
		// 3. 회원가입 창
		
		// 3-1. 회원가입 전체 패널
		signUpPanel = new JPanel();
		signUpPanel.setLayout(new FlowLayout());
		signUpPanel.add(new JLabel("회원가입"));
		
		// 회원가입 - 아이디
		signUpPanel.add(new JLabel("ID"));
		idField2 = new JTextField(10);
		signUpPanel.add(idField2);
		
		// 회원가입 - 패스워드
		signUpPanel.add(new JLabel("PW"));
		pwField2 = new JPasswordField(10);
		signUpPanel.add(pwField2);
		
		// 회원가입 - 이름
		signUpPanel.add(new JLabel("Name"));
		nameField = new JTextField(10);
		signUpPanel.add(nameField);
		
		// 회원가입 - 나이
		signUpPanel.add(new JLabel("나이"));
		ageField = new JTextField(10);
		signUpPanel.add(ageField);
		
		// 회원가입 - 전화번호
		signUpPanel.add(new JLabel("전화번호"));
		telField = new JTextField(10);
		signUpPanel.add(telField);
		
		
		
		// 회원가입 - 이메일
		signUpPanel.add(new JLabel("이메일"));
		emailField = new JTextField(10);
		signUpPanel.add(emailField);
		
		// 3-2. 회원가입 버튼 생성
		signUpButton = new JButton("Sign Up");
		signUpPanel.add(signUpButton);
		
		
	}
	
	public void viewDelete() {
		
		// 4. 회원가입 창
		
		// 4-1. 회원가입 전체 패널
		deleteAccPanel = new JPanel();
		deleteAccPanel.setLayout(new FlowLayout());
		deleteAccPanel.add(new JLabel("회원 탈퇴"));
		
		
		// 4-2. 회원탈퇴 버튼 생성
		deleteButton = new JButton("Delete Account");
		deleteAccPanel.add(deleteButton);
		
		
		
	}
	
	
	// 버튼 이벤트 생성을 위해 private인 버튼, 텍스트 필드를 컨트롤러로 넘김
	
	
	public static JTextField getIdField1() {
		return idField1;
	}
	
	public static JPasswordField getPwField1() {
		return pwField1;
	}
	
	public static JButton getLoginButton() {
		return loginButton;
	}
	
	public static JButton getLogOutButton() {
		return logOutButton;
	}
	
	public static JTextField getIdField2() {
		return idField2;
	}
	
	public static JPasswordField getPwField2() {
		return pwField2;
	}
	
	public static JTextField getNameField() {
		return nameField;
	}
	
	public static JTextField getAgeField() {
		return ageField;
	}
	
	public static JTextField getTelField() {
		return telField;
	}
	
	public static JTextField getEmailField() {
		return emailField;
	}
	
	public static JButton getSignUpButton() {
		return signUpButton;
	}
	
	public static JButton getDeleteButton() {
		return deleteButton;
	}
	
	
	
}
