package c01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest_Insert2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = DriverManager.getConnection(url,uid,upw);
		
		//쿼리 담당 객체
		//Statement stmt = conn.createStatement();->쿼리를 실행하는 객체
		
		String id = "mss";
		String pw = "1234";
		String name = "mss's";
		String phone = "010-1234-5295";
		String grade = "A";
		
		String query = "INSERT INTO tbl_member VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2,pw);
		pstmt.setString(3, name);
		pstmt.setString(4, phone);
		pstmt.setString(5, grade);
		
		
		
		
		int result = pstmt.executeUpdate();//prepare로 실행되는 쿼리는 파라미터를 안 넣는다.
		
		System.out.println("result = "+result);
		

	}

}