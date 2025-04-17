package chapter05;

import java.sql.SQLException;
import java.util.Scanner;

import chapter05_vo.DBcon;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		DBcon jdbc = new DBcon();
		jdbc.connect();
		ProductService product = new ProductService(sc,jdbc);
		CustomerService customer = new CustomerService(sc, jdbc);
		StoreService store = new StoreService(sc, jdbc);
		//고객 정보 입력 구현 완료
		//customer.customerInfo();
		//입고 처리 구현 완료
		store.storeInfo();
		//고객 정보 수정 구현 완료
		//customer.customerUpdateInfo();
		//고객정보 삭제
		//customer.customerDeleteInfo();
		

	}

}
