package ex05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButilTest {

	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = DButil.getConnection();
		String query = "SELECT * FROM tbl_member";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("DB에서 데이터를 성공적으로 가져왔습니다!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.close(conn, pstmt, rs);
		

	}

}
