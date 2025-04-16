package c05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import c01.Member;

public class Login {
	Scanner sc = new Scanner(System.in);
	Check_log cl = new Check_log();
	static int cnt;

	public void login() throws ClassNotFoundException, SQLException {
		boolean flag = true;
		while (flag) {
			System.out.println("로그인을 해주세요");
			System.out.print("ID>> ");
			String id = sc.nextLine();
			System.out.print("PW>> ");
			String pw = sc.nextLine();

			

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:testdb";
			String uid = "green";
			String upw = "1234";
			Connection conn = DriverManager.getConnection(url, uid, upw);

			String query = "SELECT * FROM tbl_member WHERE id = ? AND pw = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();//ID와 비밀번호가 일치하는 항목만 가져오기

			if (rs.next()) {//검사해서 있으면 로그인 정보를 저장하고 성공을 출력
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setGrade(rs.getString("grade"));

				System.out.println("로그인에 성공하였습니다!");
				cnt = cnt+1;
				Map<String, String>map = new HashMap<>();
				map.put(m.getId(), m.getName());
				System.out.println(map.get(m.getId()));
				System.out.println(m.getName() + "님 환영합니다!");
				flag = false;
			} else {//맞는 값이 없어서 아무런 데이터가 넘어오지 않으면 로그인 정보를 확인하라는 메시지 출력
				System.out.println("로그인 정보를 확인해주세요");
			}

		}

	}

}
