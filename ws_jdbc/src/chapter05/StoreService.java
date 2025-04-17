package chapter05;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import chapter05_vo.DBcon;
import chapter05_vo.Stock;
import chapter05_vo.Store;

public class StoreService {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

	StoreService(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

	// 중복확인 함수
	private int check(String s) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Stock WHERE c_code = ?";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setString(1, s);
		ArrayList<Stock> list = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery(query);
		if (rs.next()) {
			return 1;
		} else {
			return 0;
		}

	}

	public void storeInfo() throws ClassNotFoundException, SQLException {
		Store s = new Store();
		while (true) {
			System.out.print("상품코드를 입력해주세요>> ");
			s.setP_code(sc.nextLine());

			if (check(s.getP_code()) != 1) {
				System.out.println("존재하지 않는 상품번호 입니다!");
				continue;

			} else {
				break;
			}
		}

		System.out.print("입고 수량을 입력해주세요>> ");
		s.setS_sto(sc.nextInt());

		String query = "INSERT INTO store VALUES(?,?)";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setString(1, s.getP_code());
		pstmt.setInt(2, s.getS_sto());
		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("입고 작업이 정상 처리되었습니다!");
			System.out.println("입고 작업 내역서");
			System.out.println(s.toString());
		}

	}

}
