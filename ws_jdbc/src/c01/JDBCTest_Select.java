package c01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest_Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Member> list = new ArrayList<>();
		Class.forName("oracle.jdbc.driver.OracleDriver");// 안써도 괜찮지만 작성을 권장함

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";// 로컬에 1521포트에 testdb->db주소
		String user = "green";// 사용자 계정
		String password = "1234";// 사용자 비밀번호
		// 접속 담당 - Connection
		Connection conn = DriverManager.getConnection(url, user, password);// conn에다가 연결된 생성자 할당 조회는 결과가 따라옴
		// 조회 = 쿼리를 작성, 실행하고 결과를 받아내는것 까지가 조회
		// 쿼리 실행 - Statement
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM tbl_member";// 쿼리를 문자열로 저장
		ResultSet rs = stmt.executeQuery(query);// 쿼리를 실행
		
		
		while (rs.next()) {
			// 데이터를 읽는 위치가 처음에는 데이터를 가르키고있지 않다!! 헤더를 옮겨줘야함 .next로
			Member member = new Member();
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String grade_temp = rs.getString("grade");
			char grade = grade_temp.charAt(0);

			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setPhone(phone);
			//member.setGrade(grade);

			list.add(member);
		}
		for(Member m : list) {
			System.out.println(m);
		}

	}

}
