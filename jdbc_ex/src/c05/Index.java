package c05;

import java.sql.SQLException;
import java.util.Scanner;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		JDBC_service js = new JDBC_service();
		Login log = new Login();
		//js.insert_member();
		//js.select_all();
		//log.login();
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 전체 게시글 조회\n4. 로그아웃");
			System.out.print("원하는 번호를 선택해주세요>> ");
			int check = sc.nextInt();
			if(check == 1) {
				js.insert_member();
			}
			else if(check == 2) {
				log.login();
			}
			else if(check ==3) {
				js.select_all();
			}
			
			
		}
		

	}

}
