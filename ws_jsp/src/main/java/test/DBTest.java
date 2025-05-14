package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBcon db = new DBcon();
		String query = "SELECT * FROM t1";
		PreparedStatement pstmt = db.connect().prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			int age = rs.getInt("age");
			String name = rs.getString("name");
			int phone = rs.getInt("phone");
			System.out.println(age);
			System.out.println(name);
			System.out.println(phone);
		}
	
		
	}
	

}
