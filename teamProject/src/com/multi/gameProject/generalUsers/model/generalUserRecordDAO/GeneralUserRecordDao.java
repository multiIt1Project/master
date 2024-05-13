package com.multi.gameProject.generalUsers.model.generalUserRecordDAO;

import com.multi.gameProject.generalUsers.model.generalUserRecordDTO.GeneralUserRecordDto;

import java.sql.*;
import java.util.ArrayList;

public class GeneralUserRecordDao {
	
	
	public ArrayList<GeneralUserRecordDto> selectAll() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		ArrayList<GeneralUserRecordDto> list = new ArrayList<GeneralUserRecordDto>();
		
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
			
			String sql = "SELECT * FROM RECORD ORDER BY TOTAL_SCORE DESC";
			
			ps = con.prepareStatement(sql);
			
			rset = ps.executeQuery();
			
			System.out.println("sql문 전송 성공!! : " + rset);
			
			while (rset.next()) {
				GeneralUserRecordDto generalUserRecordDto = new GeneralUserRecordDto();
				
				// 속성 4개인 레코드 테이블
				generalUserRecordDto.setUser_Id(rset.getString("USER_ID"));
				generalUserRecordDto.setHigh_Score(rset.getInt("HIGH_SCORE"));
				generalUserRecordDto.setLevel_No(rset.getInt("LEVEL_NO"));
				generalUserRecordDto.setTotal_Score(rset.getInt("TOTAL_SCORE"));
				
				// 어레이리스트에 테이블의 행별로 담기
				list.add(generalUserRecordDto);
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
}
