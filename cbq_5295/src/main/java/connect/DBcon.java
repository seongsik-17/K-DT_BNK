package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
	public static Connection getConnection()  {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb",
					"green","1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}