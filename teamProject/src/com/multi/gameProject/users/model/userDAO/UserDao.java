package com.multi.gameProject.users.model.userDAO;

import com.multi.gameProject.users.model.userDto.UserDto;

import java.sql.*;

// 사용자 : scott / tiger , 테이블 :  USERS
public class UserDao {
	
	// 회원가입 : 유저 생성
	public void insert(UserDto newUser) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// 오라클 오류로 mysql 로 설정함. 오류 원인 찾을 예정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공..");
			
			// users 테이블에 삽입
			String url = "jdbc:mysql://localhost:3306/scott?";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공.");
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토커밋 설정 비활성화.");
			
			// USERS 테이블에 삽입
			String sql = "insert into USERS values (?, ?, ?, ?, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql); // 처리 된 행 수
			
			// ?에 입력될 순서대로 잘 매핑시키기
			ps.setString(1, newUser.getId());
			ps.setString(2, newUser.getPw());
			ps.setString(3, newUser.getName());
			ps.setInt(4, newUser.getAge());
			ps.setString(5, newUser.getEmail());
			ps.setString(6, newUser.getTel());
			
			
			System.out.println("4. sql문 객체 생성 성공");
			
			int result = ps.executeUpdate();
			
			
			System.out.println("5. sql문 전송 성공, 결과1>> " + result);
			
			// 트랜잭션 커밋
			if (result >= 1) {
				System.out.println("데이터 입력 완료");
				con.commit();
				System.out.println("6. 트랜잭션 커밋 완료.");
				
			}
			// Query가 제대로 실행되지 않은 경우
			else {
				System.out.println("데이터 입력 실패");
				con.rollback();
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
				ps.close(); // 먼저닫기
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			}
			
			
		}
		
		
	}
	
	
	// 회원 탈퇴 : 유저 삭제
	public void delete(String id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// mysql로 바꿈. 오라클 오류 해결하면 수정 예정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공..");
			
			
			String url = "jdbc:mysql://localhost:3306/scott?";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공.");
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토커밋 설정 비활성화.");
			
			// sql문 만들기 , preparedstatement :준비된 문장 만들기
			String sql = "delete from MEMBER where id = ?";
			ps = con.prepareStatement(sql); // 처리 된 행 수
			
			// ?에 입력될 순서대로 잘 매핑시키기
			ps.setInt(1, Integer.parseInt(id));
			
			
			System.out.println("4. sql문 객체 생성 성공");
			
			int result = ps.executeUpdate(); //ps 객체 실행, 쿼리실행, 반환값(변경된 행의 수) 넘어옴 받아줌.
			
			
			System.out.println("5. sql문 전송 성공, 결과1>> " + result);
			
			// 트랜잭션 커밋
			if (result >= 1) {
				System.out.println("데이터 삭제 완료");
				con.commit();
				System.out.println("6. 트랜잭션 커밋 완료.");
				
			}
			// Query가 제대로 실행되지 않은 경우
			else {
				System.out.println("데이터 삭제 실패");
				con.rollback();
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
				ps.close(); // 먼저닫기
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			}
			
			
		}
		
		
	}
	
	
	// 유저 조회
	public UserDto selectOne(String id) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDto userDTO = null;
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공..");
			
			
			String url = "jdbc:mysql://localhost:3306/scott?";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공.");
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토커밋 설정 비활성화.");
			
			// sql문 만들기 , preparedstatement :준비된 문장 만들기
			String sql = "select * from USERS where id = ?";
			ps = con.prepareStatement(sql); // 처리 된 행 수
			
			// ?에 입력될 순서대로 잘 매핑시키기
			ps.setInt(1, Integer.parseInt(id));
			
			System.out.println("4. sql문 객체 생성 성공");
			
			rs = ps.executeQuery(); //ps 객체 실행, 쿼리실행, 반환값(변경된 행의 수) 넘어옴 받아줌.
			
			if (rs.next()) {
				
				userDTO = new UserDto();
				userDTO.setId("id");
				userDTO.setPw(rs.getString("pw"));
				userDTO.setName(rs.getString("name"));
				userDTO.setAge(rs.getInt("age"));
				userDTO.setTel(rs.getString("tel"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setCreateDate(rs.getDate("create_date"));
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
				ps.close(); // 먼저닫기
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			}
			
			
		}
		
		return userDTO;
		
	}
	
	
	//  로그인
	public UserDto logIn(UserDto userDto) {
		
		UserDto rsDTO = null;
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 설정 성공..");
			
			
			String url = "jdbc:mysql://localhost:3306/scott?";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db연결 성공.");
			
			// 오토커밋을 false로 설정
			con.setAutoCommit(false);
			System.out.println("3. 오토커밋 설정 비활성화.");
			
			// sql문 만들기 , preparedstatement :준비된 문장 만들기
			String sql = "select * from MEMBER where id = ? and pw=?";
			ps = con.prepareStatement(sql); // 처리 된 행 수
			
			// ?에 입력될 순서대로 잘 매핑시키기
			ps.setString(1, userDto.getId());
			ps.setString(2, userDto.getPw());
			
			System.out.println("4. sql문 객체 생성 성공");
			
			rs = ps.executeQuery(); //ps 객체 실행, 쿼리실행, 반환값(변경된 행의 수) 넘어옴 받아줌.
			
			if (rs.next()) {
				
				rsDTO = new UserDto();
				rsDTO.setId(rs.getString("id"));
				
				rsDTO.setPw(rs.getString("pw"));
				rsDTO.setName(rs.getString("name"));
				rsDTO.setAge(rs.getInt("age"));
				rsDTO.setTel(rs.getString("tel"));
				rsDTO.setEmail(rs.getString("email"));
				rsDTO.setCreateDate(rs.getDate("create_date"));
				
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
				ps.close(); // 먼저닫기
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			}
			
			
		}
		
		
		return rsDTO;
		
		
	}
	
	
}
