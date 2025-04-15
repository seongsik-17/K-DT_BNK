package book_sys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDAO {
	Scanner sc = new Scanner(System.in);
	private final Connction_sql db;// 상수

	public BookDAO(Connction_sql db) {
		this.db = db;
	}

	public void insert() throws SQLException, ClassNotFoundException {// 삽입
		
		while(true) {
			Book b = new Book();
			db.connsql();
			System.out.print("책 번호>> ");
			b.setBno(sc.nextInt());
			sc.nextLine();
			String query_test = "SELECT * FROM tbl_book WHERE bno = ?" ;
			PreparedStatement pstmt_test = db.connsql().prepareStatement(query_test);
			pstmt_test.setInt(1, b.getBno());
			ResultSet rs = pstmt_test.executeQuery();
			System.out.print("책 제목>> ");
			b.setBtitle(sc.nextLine());
			System.out.print("책 저자>> ");
			b.setBwriter(sc.nextLine());
			System.out.print("책 출판사>> ");
			b.setBco(sc.nextLine());
			System.out.print("책 가격>> ");
			b.setBprice(sc.nextInt());

			System.out.println("입력된 값 ▼");
			System.out.println(b.toString());
			

			
			String query = "INSERT INTO tbl_book VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = db.connsql().prepareStatement(query);
			pstmt.setInt(1, b.getBno());
			pstmt.setString(2, b.getBtitle());
			pstmt.setString(3, b.getBwriter());
			pstmt.setString(4, b.getBco());
			pstmt.setInt(5, b.getBprice());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("책 정보가 정상적으로 입력 되었습니다.");
				System.out.println(b.toString());
				break;
			}
		}

		

	}

	public void select() throws SQLException, ClassNotFoundException {// 선택(조회)

		String query = "SELECT * FROM tbl_book";
		PreparedStatement pstmt = db.connsql().prepareStatement(query);

		ArrayList<Book> blist = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery(query);
		while (rs.next()) {
			Book b = new Book();
			b.setBno(rs.getInt("bno"));
			b.setBtitle(rs.getString("btitle"));
			b.setBwriter(rs.getString("bwriter"));
			b.setBco(rs.getString("bco"));
			b.setBprice(rs.getInt("bprice"));

			blist.add(b);
		}
		for (Book bk : blist) {
			System.out.println(bk);
		}
	}

	public void updateint(int i, int s, int c) throws ClassNotFoundException, SQLException {// 갱신
		int result;
		PreparedStatement pstmt;
		String query;
		switch (i) {
		case 1 -> {
			query = "UPDATE tbl_book SET bno = ? WHERE bno = ?";
			pstmt = db.connsql().prepareStatement(query);
			pstmt.setInt(1, c);
			pstmt.setInt(2, s);
			result = pstmt.executeUpdate();
			if(result ==1) {
				System.out.println("정상 처리되었습니다...");
			}

		}
		case 5 -> {
			query = "UPDATE tbl_book SET bprice = ? WHERE bno = ?";
			pstmt = db.connsql().prepareStatement(query);
			pstmt.setInt(2, s);
			pstmt.setInt(1, c);
			
			result = pstmt.executeUpdate();
			if(result ==1) {
				System.out.println("정상 처리되었습니다...");
			}

		}
		}

	}

	public void updatestring(int i, int sbook, String s) throws SQLException, ClassNotFoundException {
		int result;
		PreparedStatement pstmt;
		String query;
		if (i == 2) {
			query = "UPDATE tbl_book SET btitle = ? WHERE bno = ?";
			pstmt = db.connsql().prepareStatement(query);
			pstmt.setInt(2, sbook);
			pstmt.setString(1, s);
			
			result = pstmt.executeUpdate();
			if(result ==1) {
				System.out.println("정상 처리되었습니다...");
			}

		}
		else if(i == 3) {
			query = "UPDATE tbl_book SET bwriter = ? WHERE bno = ?";
			pstmt = db.connsql().prepareStatement(query);
			pstmt.setInt(2, sbook);
			pstmt.setString(1, s);
			result = pstmt.executeUpdate();
			if(result ==1) {
				System.out.println("정상 처리되었습니다...");
			}
		}
		else if(i == 4) {
			query = "UPDATE tbl_book SET bco = ? WHERE bno = ?";
			pstmt = db.connsql().prepareStatement(query);
			pstmt.setInt(2, sbook);
			pstmt.setString(1, s);
			result = pstmt.executeUpdate();
			if(result ==1) {
				System.out.println("정상 처리되었습니다...");
			}
			
		}

	}

	public void delete(int i) throws ClassNotFoundException, SQLException {// 삭제
		String query = "DELETE FROM tbl_book WHERE bno =?";
		PreparedStatement pstmt = db.connsql().prepareStatement(query);
		pstmt.setInt(1, i);
		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("정상적으로 삭제 되었습니다.");
		}

	}

}
