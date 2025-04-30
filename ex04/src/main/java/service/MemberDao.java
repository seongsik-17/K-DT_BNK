package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.Member;
import connection.DBcon;

public class MemberDao {
	//1.삽입
	Connection conn = DBcon.Connect();
	PreparedStatement pstmt;
	ResultSet rs;
	public int insert(String id, String pw, String name, String grade) {
		int result = 0;
		String query = "INSERT INTO member1 VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, grade);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	//2.개별조회
	public Member select(String id) {
		Member mb = new Member();
		String query = "SELECT * FROM member1 WHERE id = ?";
		List<Member> list = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setName(rs.getString("name"));
				mb.setGrade(rs.getString("grade"));
				
				list.add(mb);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mb;
	}

}
