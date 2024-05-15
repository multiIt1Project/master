package com.multi.gameProject.generalUsers.model.dao;

import com.multi.gameProject.common.JDBCTemplate;
import com.multi.gameProject.generalUsers.model.dto.GeneralUserBoardDto;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class GeneralUserBoardDao {
	
	private Properties prop = null;
	
	public GeneralUserBoardDao() {
		
		prop = new Properties();
		try {
			prop = new Properties();
			prop.load(new FileReader("resources/AJY/generalboardQuery.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<GeneralUserBoardDto> selectAllBoard(Connection con) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rset = null;
		ArrayList<GeneralUserBoardDto> list = new ArrayList<GeneralUserBoardDto>();
		
		
		String sql = prop.getProperty("selectAllBoard");
		try {
			
			ps = con.prepareStatement(sql);
			
			rset = ps.executeQuery();
			
			System.out.println("sql문 전송 성공!! : " + rset);
			
			while (rset.next()) {
				GeneralUserBoardDto generalUserBoardDto = new GeneralUserBoardDto();
				
				// 속성 5개인 게시판 테이블
				generalUserBoardDto.setNo(rset.getInt("NO"));
				generalUserBoardDto.setUser_Id(rset.getString("USER_ID"));
				generalUserBoardDto.setWrite_Date(rset.getDate("WRITE_DATE"));
				generalUserBoardDto.setTitle(rset.getString("TITLE"));
				generalUserBoardDto.setContent(rset.getString("CONTENT"));
				
				// 어레이리스트에 테이블의 행별로 담기
				list.add(generalUserBoardDto);
			}
			System.out.println("sql문 전송 성공, 결과 >> " + rset);
			
			
		} catch (SQLException e) {
			/*System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();*/
			throw new Exception("sql에러 발생!!" + e.getMessage());
			
			
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(ps);
			
		}
		return list;
		
		
	}
	
	public ArrayList<GeneralUserBoardDto> selectList(Connection con, String id) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rset = null;
		ArrayList<GeneralUserBoardDto> list = new ArrayList<GeneralUserBoardDto>();
		
		String sql = prop.getProperty("selectBoard");
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rset = ps.executeQuery();
			
			System.out.println("sql문 전송 성공!! : " + rset);
			
			while (rset.next()) {
				GeneralUserBoardDto generalUserBoardDto = new GeneralUserBoardDto();
				
				// 속성 5개인 게시판 테이블
				generalUserBoardDto.setNo(rset.getInt("NO"));
				generalUserBoardDto.setUser_Id(rset.getString("USER_ID"));
				generalUserBoardDto.setWrite_Date(rset.getDate("WRITE_DATE"));
				generalUserBoardDto.setTitle(rset.getString("TITLE"));
				generalUserBoardDto.setContent(rset.getString("CONTENT"));
				
				// 어레이리스트에 테이블의 행별로 담기
				list.add(generalUserBoardDto);
			}
			System.out.println("sql문 전송 성공, 결과 >> " + rset);
			
			
		} catch (SQLException e) {
			/*System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();*/
			
			throw new Exception("sql에러 발생!!" + e.getMessage());
			
			/*if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}*/
			
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(ps);
			
			
		}
		return list;
		
		
	}
	
	public int editBoard(Connection con, int no, String edit2Content) throws Exception {
		
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = prop.getProperty("editBoard");
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, edit2Content);
			ps.setInt(2, no);
			
			result = ps.executeUpdate();
			
			/*System.out.println("sql문 전송 성공, 결과 >> " + result);
			
			// 커밋하는 부분 생성!!
			if (result > 0) {
				System.out.println("게시판 수정 완료");
				con.commit();
				System.out.println("커밋 완료");
				
			} else {
				System.out.println("데이터 수정 실패,,, result=0");
				con.rollback();
			}*/
			
			
		} catch (SQLException e) {
			/*System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();*/
			throw new Exception("sql에러 발생!!" + e.getMessage());
			/*
			if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}*/
			
		} finally {
			JDBCTemplate.close(ps);
			
		}
		return result;
		
		
	}
	
	public GeneralUserBoardDto selectOneBoard(Connection con, int no) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rset = null;
		GeneralUserBoardDto generalUserBoardDto = null;
		
		
		String sql = prop.getProperty("selectOneBoard");
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, String.valueOf(no));
			
			rset = ps.executeQuery();
			
			System.out.println("sql문 전송 성공!! : " + rset);
			
			if (rset.next()) {
				generalUserBoardDto = new GeneralUserBoardDto();
				
				// 속성 5개인 게시판 테이블
				generalUserBoardDto.setNo(rset.getInt("NO"));
				generalUserBoardDto.setUser_Id(rset.getString("USER_ID"));
				generalUserBoardDto.setWrite_Date(rset.getDate("WRITE_DATE"));
				generalUserBoardDto.setTitle(rset.getString("TITLE"));
				generalUserBoardDto.setContent(rset.getString("CONTENT"));
				
			}
			System.out.println("sql문 전송 성공, 결과 >> " + rset);
			
			
		} catch (SQLException e) {
			/*System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();*/
			throw new Exception("sql에러 발생!!" + e.getMessage());
			
			/*if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}*/
			
		} finally {
			/*try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			JDBCTemplate.close(rset);
			JDBCTemplate.close(ps);
			
			
		}
		return generalUserBoardDto;
		
		
	}
	
	public int insertBoard(Connection con, String title, String content, String userId) throws Exception {
		
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = prop.getProperty("insertBoard");
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			ps.setString(2, title);
			ps.setString(3, content);
			
			System.out.println("sql문 전송 성공!! : " + ps);
			
			result = ps.executeUpdate();
			
			/*System.out.println("sql문 전송 성공, 결과 >> " + result);
			
			if (result > 0) {
				System.out.println("데이글 삽입 완료");
				con.commit();
				System.out.println("커밋 완료");
				
			} else {
				System.out.println("게시글 삽입 실패,,, result=0");
				con.rollback();
			}*/
			
			
		} catch (SQLException e) {
			/*System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();*/
			throw new Exception("sql 에러 발생!!" + e.getMessage());
			
			/*if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}*/
			
		} finally {
			
			JDBCTemplate.close(ps);
			
			/*try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			
			
		}
		return result;
		
		
	}
}
