package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.Board;
import connection.DBcon;

public class BoardDao {
	Connection conn = DBcon.Connect();
	PreparedStatement pstmt;
	ResultSet rs;
	public List select() {
		
		List<Board> blist = new ArrayList<>();
		String query = "SELECT * FROM tbl_board ORDER BY bno";
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setBno(rs.getInt("bno"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setRegdate(rs.getString("regdate"));
				
				blist.add(b);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}//SELECT 종료
	//INSERT
	public void insertboard(Board b) {
		String query = "INSERT INTO tbl_board VALUES(seq_board.NEXTVAL,?,?,?,SYSDATE)";
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getWriter());
			
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("1");
			}
		} catch (SQLException e) {
			System.out.println("sql삽입 실패");
			System.out.println(b.toString());
			e.printStackTrace();
		}
		
	}
	

}
