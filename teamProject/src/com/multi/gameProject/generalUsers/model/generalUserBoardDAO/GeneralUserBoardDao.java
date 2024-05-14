package com.multi.gameProject.generalUsers.model.generalUserBoardDAO;

import com.multi.gameProject.generalUsers.model.generalUserBoardDTO.GeneralUserBoardDto;

import java.sql.*;
import java.util.ArrayList;

public class GeneralUserBoardDao {
	
	
	public ArrayList<GeneralUserBoardDto> allList() {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		ArrayList<GeneralUserBoardDto> list = new ArrayList<GeneralUserBoardDto>();
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 설정 성공..");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공." + con);
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토 커밋 설정 비활성화.");
			
			String sql = "SELECT * FROM BOARD ORDER BY NO ASC";
			
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
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();
			
			if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return list;
		
		
	}
	
	public ArrayList<GeneralUserBoardDto> selectList(String id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		ArrayList<GeneralUserBoardDto> list = new ArrayList<GeneralUserBoardDto>();
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 설정 성공..");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공." + con);
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토 커밋 설정 비활성화.");
			
			String sql = "SELECT * FROM BOARD WHERE USER_ID = ? ORDER BY NO ASC";
			
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
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();
			
			if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return list;
		
		
	}
	
	public int editBoard(int no, String edit2Content) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 설정 성공..");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공." + con);
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토 커밋 설정 비활성화.");
			
			String sql = "UPDATE BOARD SET CONTENT = ? WHERE NO = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, edit2Content);
			ps.setInt(2, no);
			
			result = ps.executeUpdate();
			
			System.out.println("sql문 전송 성공, 결과 >> " + result);
			
			// 커밋하는 부분 생성!!
			if (result > 0) {
				System.out.println("게시판 수정 완료");
				con.commit();
				System.out.println("커밋 완료");
				
			} else {
				System.out.println("데이터 수정 실패,,, result=0");
				con.rollback();
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();
			
			if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return result;
		
		
	}
	
	public GeneralUserBoardDto selectOne(int no) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		GeneralUserBoardDto generalUserBoardDto = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 설정 성공..");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공." + con);
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토 커밋 설정 비활성화.");
			
			String sql = "SELECT * FROM BOARD WHERE NO = ?";
			
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
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();
			
			if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return generalUserBoardDto;
		
		
	}
	
	public int insertBoard(String title, String content, String userId) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 설정 성공..");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공." + con);
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토 커밋 설정 비활성화.");
			
			String sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, SYSDATE, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			ps.setString(2, title);
			ps.setString(3, content);
			
			System.out.println("sql문 전송 성공!! : " + ps);
			
			result = ps.executeUpdate();
			
			System.out.println("sql문 전송 성공, 결과 >> " + result);
			
			if (result > 0) {
				System.out.println("데이글 삽입 완료");
				con.commit();
				System.out.println("커밋 완료");
				
			} else {
				System.out.println("게시글 삽입 실패,,, result=0");
				con.rollback();
			}
			
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("sql 에러 발생!! 회원 존재 안함");
			e.printStackTrace();
			
			if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}
			
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return result;
		
		
		
	}
}
