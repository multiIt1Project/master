package com.multi.gameProject.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// 커넥션 관리를 위해 커넥션 객체를 단 하나만 사용하게 함
public class JDBCTemplate {
	
	private static Connection conn = null;
	
	// 커넥션을 반환하는 메서드
	public static Connection getConnection() {
		
		if (conn == null) {
			try {
				Properties prop = new Properties();
				prop.load(new FileReader("resources/driver.properties"));
				
				Class.forName(prop.getProperty("driver"));
				
				System.out.println("오라클 드라이버 등록 성공");
				
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				
				conn = DriverManager.getConnection(url, prop);
				
				System.out.println("conn = " + conn);
				
				conn.setAutoCommit(false);
				
			} catch (IOException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		return conn;
		
	}
	
	public static void close(Connection con) {
		
		try {
			if(con != null && !con.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("close(connection) 에러 발생!!");
			e.printStackTrace();
		}
		
	}
	
	
	public static void commit(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
