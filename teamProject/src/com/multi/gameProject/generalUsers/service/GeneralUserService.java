package com.multi.gameProject.generalUsers.service;

import com.multi.gameProject.common.JDBCTemplate;
import com.multi.gameProject.generalUsers.model.dao.GeneralUserDao;
import com.multi.gameProject.generalUsers.model.dto.GeneralUserDto;

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
	
	
	public int insertUser(GeneralUserDto newUser) throws Exception {
		
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = generalUserDao.insertUser(con, newUser);
		
		if (result > 0) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		return result;
		
	}
	
	public GeneralUserDto userLogin(String userId, String userPw) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		GeneralUserDto loginDto = new GeneralUserDto();
		
		loginDto = generalUserDao.userLogin(con, userId, userPw);
		
		
		
		
		return loginDto;
		
	}
	
	public int updateUser(GeneralUserDto updatedUser) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = generalUserDao.updateUser(con, updatedUser);
		
		if(result>0) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
			
		}
		
		System.out.println(result);
		return result;
	}
	
	public GeneralUserDto selectUser(String userId) {
		
		GeneralUserDto generalUserDto = new GeneralUserDto();
		
		generalUserDto = generalUserDao.selectUser(userId);
		
		return generalUserDto;
		
		
		
	}
	
	public int deleteUser(String userId, String userPw) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = generalUserDao.deleteUser(con, userId, userPw);
		
		if(result>0) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		
		
		return result;
		
		
		
	}
}
