package c05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import c01.Member;

public class JDBC_service {
	Scanner sc = new Scanner(System.in);
	Member mb = new Member();
	Board b = new Board();

	public void insert_member() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		Connection conn = DriverManager.getConnection(url, uid, upw);

		while (true) {
			System.out.println("회원가입을 시작합니다.");
			System.out.print("사용할 ID를 입력해주세요>> ");
			String id = sc.nextLine();
			
			String query_id_check = "SELECT id FROM tbl_member WHERE id ="+"'"+id+"'";
			Statement stmt_id_check = conn.createStatement();
			
			ResultSet rs = stmt_id_check.executeQuery(query_id_check);
			if (rs.next()) {
				System.out.println("이미 사용중인 아이디입니다!");
				continue;
			}
			
			
			System.out.print("사용할 비밀번호를 입력해주세요>> ");
			String pw = sc.nextLine();
			System.out.print("이름>> ");
			String name = sc.nextLine();
			System.out.print("전화번호>> ");
			String phone = sc.nextLine();
			System.out.print("등급>> ");
			String grade = sc.nextLine();

			mb.setId(id);
			mb.setPw(pw);
			mb.setName(name);
			mb.setPhone(phone);
			mb.setGrade(grade);

			String query = "INSERT INTO tbl_member VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPw());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getPhone());
			pstmt.setString(5, mb.getGrade());

			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("회원가입이 정상적으로 처리되었습니다!");
				System.out.println(mb.toString());
				break;
			}
		}

	}// 회원가입 끝.
		// 게시글 작성하는 모듈

	public void insert_board() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		Connection conn = DriverManager.getConnection(url, uid, upw);
		System.out.println("게시번호>> ");
		int bno = sc.nextInt();
		System.out.println("제목>> ");
		String title = sc.nextLine();
		System.out.println("내용>> ");
		String content = sc.nextLine();

		b.setBno(bno);
		b.setTitle(title);
		b.setContent(content);
		b.setRegdate("SYSDATE");// 리얼타임
		// 로그인 정보를 가져와야함(미구현)
	}

	// 전체 게시판 정보 조회
	public void select_all() throws ClassNotFoundException, SQLException {
		ArrayList<Board> list = new ArrayList<>();

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		Connection conn = DriverManager.getConnection(url, uid, upw);

		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM tbl_board";// 쿼리를 문자열로 저장
		ResultSet rs = stmt.executeQuery(query);// 쿼리를 실행

		while (rs.next()) {
			Board b = new Board();
			int bno = rs.getInt("bno");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String regdate = rs.getString("regdate");

			b.setBno(bno);
			b.setTitle(title);
			b.setContent(content);
			b.setWriter(writer);
			b.setRegdate(regdate);

			list.add(b);

		}
		for (Board blist : list) {
			System.out.println(blist);
		}
	}

	// 전체 사용자 정보 select

}
