package ex05.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	//데이터는 인스턴스의 상태
	//1.접속 객체(Connection )제공
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uid,upw);
			if(conn != null) {
				System.out.println("DB연결 성공");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
		
	}
	//2. Dao에서 사용된 자원 해제(Connection, Statement, ResultSet)
	public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		try {
			
			if(rs != null) {
				rs.close();
				close(conn,pstmt);
			}
			
			System.out.println("추가로 rs자원 해제");
		} catch (SQLException e) {
			e.printStackTrace();
			
		}// 조회를 제외하고는 사용하지 않음
		
	}
	
	public static void close(Connection conn,PreparedStatement pstmt) {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
			System.out.println("conn, pstmt 자원 해제");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
