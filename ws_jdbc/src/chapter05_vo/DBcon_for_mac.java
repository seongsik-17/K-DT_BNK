package chapter05_vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Data;
@Data
public class DBcon_for_mac {
	
	public Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "system";
		String pw = "pass";
		
		Connection conn = DriverManager.getConnection(url,id,pw);
		
		return conn;
	}
	

}
