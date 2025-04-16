package c01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";
		
		Connection conn = DriverManager.getConnection(url,id,pw);
		
		//쿼리 담당 객체
		Statement stmt = conn.createStatement();
		
		String query = "INSERT INTO tbl_member VALUES('id8','8888','팔식','010-8888-8888','A')";
		int result = stmt.executeUpdate(query);
		
		System.out.println("result = "+result);
		

	}

}