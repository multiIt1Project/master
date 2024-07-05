package com.multi.gameProject.users.app;

import com.multi.gameProject.users.controller.UserController;

public class UserRun {
	
	public static void main(String[] args) {
		
		// 데이터 넣을 테이블 생성 쿼리 실행
		
		
		// 유저 뷰 컨트롤러 실행
		UserController userCtrl= new UserController();
		
		userCtrl.userController();
		
	}
	
	
}
