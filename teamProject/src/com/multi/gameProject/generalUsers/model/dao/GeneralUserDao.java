package com.multi.gameProject.generalUsers.model.dao;

import com.multi.gameProject.common.JDBCTemplate;
import com.multi.gameProject.generalUsers.model.dto.GeneralUserDto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// java.sql.SQLRecoverableException: 접속 종료
// 사용자 : scott / tiger , 테이블 :  USERS
public class GeneralUserDao {
	
	
	private Properties prop = null;
	
	// 다오 생성 시 쿼리 프로퍼티 파일을 읽음
	public GeneralUserDao() {
		
		try {
			prop = new Properties();
			prop.load(new FileReader("resources/AJY/generlUsersQuery.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("query file not found");
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("IO error");
			e.printStackTrace();
		}
		
		
	}
	
	// 회원가입 : 유저 생성
	public int insertUser(Connection con, GeneralUserDto newUser) throws Exception {
		
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = prop.getProperty("insertUser");
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newUser.getUser_Id());
			ps.setString(2, newUser.getPw());
			ps.setString(3, newUser.getName());
			ps.setInt(4, newUser.getAge());
			ps.setString(5, newUser.getTel());
			ps.setString(6, newUser.getEmail());
			System.out.println("sql 객체 생성 성공");
			
			result = ps.executeUpdate();
			
			/*System.out.println("sql문 전송 결과 result : " + result);
			
			if (result > 0) {
				System.out.println("데이터 입력 완료");
				con.commit();
				System.out.println("커밋 완료");
				
			} else {
				System.out.println("데이터 입력 실패,,,");
				con.rollback();
			}*/
			
		} catch (Exception e) {
			/*System.out.println("sql 에러 발생!!");
			e.printStackTrace();*/
			
			throw new Exception(e);
		}
			
			/*if (con != null) {
				try {
					con.rollback(); // 예외 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				System.out.println("트랜잭션 롤백.");
			}*/ finally {
			
			JDBCTemplate.close(ps);
			
			
		}
		return result; // result ==0 이면 중복 아이디 존재!!
		
	}
	
	
	// 회원 탈퇴 : 본인의 아이디, 비밀번호 유저 삭제
	// 아이디, 비밀번호를 한번 더 입력하게 할 예정
	public int deleteUser(Connection con, String user_Id, String pw) throws Exception{
		
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteUser");
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_Id);
			ps.setString(2, pw);
			
			System.out.println("sql 객체 생성 성공");
			
			result = ps.executeUpdate();
			
			/*System.out.println("sql문 전송 결과 result : " + result);
			
			if (result > 0) {
				System.out.println("데이터 삭제 완료");
				con.commit();
				System.out.println("커밋 완료");
				
			} else {
				System.out.println("데이터 삭제 실패,,,");
				con.rollback();
			}*/
			
		} catch (SQLException e) {
			
			throw new Exception("sql에러 발생!!" + e.getMessage());
			
			/*System.out.println("sql 에러 발생!!");
			e.printStackTrace();
			
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
	
	
	// 유저 아이디로 본인 정보 조회
	// 유저의 기능이므로 본인의 아이디가 자동으로 들어가게 설계
	public GeneralUserDto selectUser(String user_Id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		GeneralUserDto generalUserDto = null;
		
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
			
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_Id);
			
			rset = ps.executeQuery();
			
			System.out.println("sql문 전송 성공!! : " + rset);
			
			if (rset.next()) {
				generalUserDto = new GeneralUserDto();
				generalUserDto.setUser_Id(rset.getString("user_id"));
				generalUserDto.setPw(rset.getString("pw"));
				generalUserDto.setCoin_Count(rset.getInt("coin_count"));
				generalUserDto.setName(rset.getString("name"));
				generalUserDto.setAge(rset.getInt("age"));
				generalUserDto.setTel(rset.getString("tel"));
				generalUserDto.setEmail(rset.getString("email"));
				generalUserDto.setSingup_Date(rset.getDate("signup_date"));
				generalUserDto.setDel_Acc(rset.getString("del_acc").charAt(0));
				generalUserDto.setDelete_Acc_Date(rset.getDate("delete_acc_date"));
				
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
		return generalUserDto;
		
		
	}
	
	
	//  로그인
	public GeneralUserDto userLogin(Connection con, String user_Id, String pw) throws Exception {
		
		PreparedStatement ps = null;
		ResultSet rset = null;
		GeneralUserDto generalUserDto = null;
		
		String sql = prop.getProperty("userLogin");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_Id);
			ps.setString(2, pw);
			
			rset = ps.executeQuery();
			
			System.out.println("sql문 전송 성공!! : " + rset);
			
			if (rset.next()) {
				generalUserDto = new GeneralUserDto();
				generalUserDto.setUser_Id(rset.getString("user_id"));
				generalUserDto.setPw(rset.getString("pw"));
				generalUserDto.setCoin_Count(rset.getInt("coin_count"));
				generalUserDto.setName(rset.getString("name"));
				generalUserDto.setAge(rset.getInt("age"));
				generalUserDto.setTel(rset.getString("tel"));
				generalUserDto.setEmail(rset.getString("email"));
				generalUserDto.setSingup_Date(rset.getDate("signup_date"));
				generalUserDto.setDel_Acc(rset.getString("del_acc").charAt(0));
				generalUserDto.setDelete_Acc_Date(rset.getDate("delete_acc_date"));
				
			}
			System.out.println("sql문 전송 성공, 결과 >> " + rset);
			
			
		} catch (SQLException e) {
			System.out.println("sql 에러 발생!! 회원 존재 안함");
			throw e;
			
			
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(ps);
			
		}
		return generalUserDto; // 앞으로 나의 정보 관리를 위해 계속 사용될 로그인의 반환값인 디티오
		
	}
	
	
	// 로그아웃은 컨트롤러에서 확인을 누르면 바로 초기화면으로 돌아가게 설정함
	// 또한 나의 정보를 나타내는 dto를 dao 메서드를 호출하는 곳에서 null로 초기화할 것
	
	
	// 회원 업데이트. 로그인 된 상태이므로 아이디 확인 없이 바로 가져온다
	// 직접 수정 입력한 값을 가져오는 매개변수 디티오
	public int updateUser(Connection con, GeneralUserDto updatedUser) throws Exception {
		
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = prop.getProperty("updateUser");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			// 받은 입력값을 ps에 담아보냄
			ps.setString(1, updatedUser.getUser_Id());
			ps.setString(2, updatedUser.getPw());
			ps.setString(3, updatedUser.getName());
			ps.setInt(4, updatedUser.getAge());
			ps.setString(5, updatedUser.getTel());
			ps.setString(6, updatedUser.getEmail());
			ps.setString(7, updatedUser.getUser_Pre_Id());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			throw new Exception("sql에러 발생!!" + e.getMessage());
			
		} finally {
			
			JDBCTemplate.close(ps);
			
			
		}
		return result;
		
	}
}