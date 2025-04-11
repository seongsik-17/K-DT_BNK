package c02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homepage_main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.회원가입 \n2.게시판 조회\n3.게시글작성");
		int cheak = sc.nextInt();
		if (cheak == 1) {// 회원가입 클래스로 이동
			// 회원가입 구현
			Mk_account mka = new Mk_account();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:testdb";
			String id = "green";
			String pw = "1234";

			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			String qurey = "INSERT INTO tbl_member VALUES('" + mka.getId() + "','" + mka.getPw() + "','" + mka.getName()
					+ "','" + mka.getPhone() + "','A')";

			int rs = stmt.executeUpdate(qurey);
			if (rs == 1) {
				System.out.println("회원가입이 정상 처리 되었습니다.");
				System.out.println("가입된 정보▼");
				System.out.println(mka.toString());

				List<Board_R> list = new ArrayList<>();
				Class.forName("oracle.jdbc.driver.OracleDriver");

				System.out.println("전체조회");

				String qurey_s = "SELECT * FROM tbl_board";
				ResultSet rs_s = stmt.executeQuery(qurey_s);

				while (rs_s.next()) {
					Board_R br = new Board_R();
					int bno = rs_s.getInt("bno");
					String title = rs_s.getString("title");
					String content = rs_s.getString("content");
					String writer = rs_s.getString("writer");
					String date = rs_s.getString("regdate");

					br.setBon(bno);
					br.setTitle(title);
					br.setContent(content);
					br.setWriter(writer);
					br.setDate(date);

					list.add(br);
				}
				for (Board_R b : list) {
					System.out.println(b);
				}
			}

		} else if (cheak == 2) {// 게시판으로 이동
			List<Board_R> list = new ArrayList<>();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:testdb";
			String id = "green";
			String pw = "1234";
			Connection conn = DriverManager.getConnection(url, id, pw);
			Statement stmt = conn.createStatement();

			System.out.println("전체조회");

			String qurey = "SELECT * FROM tbl_board";
			ResultSet rs = stmt.executeQuery(qurey);

			while (rs.next()) {
				Board_R br = new Board_R();
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String date = rs.getString("regdate");

				br.setBon(bno);
				br.setTitle(title);
				br.setContent(content);
				br.setWriter(writer);
				br.setDate(date);

				list.add(br);
			}

			for (Board_R b : list) {
				System.out.println(b);
			}
			System.out.println("게시글을 작성하시겠습니까?\n1.예 2.아니오");
			int cheakb = sc.nextInt();

		} else if (cheak == 3) {// 게시글 작성하기
			System.out.println("게시글을 작성합니다...");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:testdb";
			String id = "green";
			String pw = "1234";

			Connection conn = DriverManager.getConnection(url, id, pw);

			// 쿼리 담당 객체
			Statement stmt = conn.createStatement();
			System.out.println("제목을 입력해주세요>> ");
			System.out.println("내용을 입력해주세요>> ");
			System.out.println("");

			String query = "INSERT INTO tbl_board VALUES('id8','8888','팔식','010-8888-8888','A')";
			int result = stmt.executeUpdate(query);

			System.out.println("result = " + result);
		}

	}

}
