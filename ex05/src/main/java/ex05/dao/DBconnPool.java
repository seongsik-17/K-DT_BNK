package ex05.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBconnPool {
	Connection conn;
	public DBconnPool() {
		try {
			Context intiCtx = new InitialContext();
			Context ctx = (Context)intiCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookupLink("dbcp_myoracle");
			
			conn = ds.getConnection();
			
			if(conn != null) {
				System.out.println("연결 성공!!");
			}
		} catch (NamingException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
