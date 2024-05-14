package com.multi.gameProject.generalUsers.service;

import com.multi.gameProject.common.JDBCTemplate;
import com.multi.gameProject.generalUsers.model.dao.GeneralUserBoardDao;
import com.multi.gameProject.generalUsers.model.dto.GeneralUserBoardDto;

import java.sql.Connection;
import java.util.ArrayList;

public class GeneralUserBoardService {
	
	private final GeneralUserBoardDao boardDao;
	
	public GeneralUserBoardService() {
		
		boardDao = new GeneralUserBoardDao();
	}
	
	public ArrayList<GeneralUserBoardDto> selectAllBoard() throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<GeneralUserBoardDto> list = boardDao.selectAllBoard(con);
		
		return list;
	}
	
	public ArrayList<GeneralUserBoardDto> selectList(String id) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<GeneralUserBoardDto> list = boardDao.selectList(con, id);
		
		return list;
	}
	
	public int editBoard(int no, String content) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = boardDao.editBoard(con, no, content);
		
		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		return result;
		
		
	}
	
	public int insertBoard(String title, String content, String userId) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = boardDao.insertBoard(con, title, content, userId);
		
		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		return result;
		
		
	}
	
	public GeneralUserBoardDto selectOneBoard(int no) throws Exception {
		
		Connection con = JDBCTemplate.getConnection();
		
		GeneralUserBoardDto boardDto = boardDao.selectOneBoard(con, no);
		
		return boardDto;
		
		
	}
	
	
	
	
}
