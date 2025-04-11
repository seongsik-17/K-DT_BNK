package c01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_UPDATE {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String id = "green";
		String pw = "1234";
		
		Connection conn = DriverManager.getConnection(url,id,pw);
		Statement stmt = conn.createStatement();
		
		String query = "UPDATE tbl_member SET phone = '010-9999-9999' WHERE id = 'id8' ";
		
		int result = stmt.executeUpdate(query);		
		System.out.println(result);

	}
	
	

}
