package ex05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex05.dto.MemberDTO;

public class MemberDAO {
	//싱글톤 제약
	private static MemberDAO memberdao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO  getMemberDao () {
		return 	memberdao;
	}
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<>();	
		Connection conn = DButil.getConnection();
		String query = "SELECT * FROM tbl_member";
		//PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(query);ResultSet rs = pstmt.executeQuery();) {
			 //자원 사용이 끝나면 자동적으로 자원을 반납하게 하는 방법
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");
				
				MemberDTO member = new MemberDTO(id, pw, name, phone, grade);
				
				list.add(member);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//			finally {
////			DButil.close(conn, pstmt, rs);
////		}
		return list;
	}
	public void insert() {
		Connection conn = DButil.getConnection();
		String query = "INSERT INTO tbl_memver VALUES(?,?,?,?,?)";
	}
	public void update() {
		Connection conn = DButil.getConnection();
		String query = "UPDATE tbl_member SET grade = ? WHERE id = ? ";
	}
	public void delete() {
		Connection conn = DButil.getConnection();
		String query = "DELETE FROM tbm_member WHERE id = ?";
	}
	

}
