package book_sys;

import java.sql.SQLException;
import java.util.Scanner;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Connction_sql cs = new Connction_sql();
		BookDAO bookd = new BookDAO(cs);

		// bookd.insert();
		// System.out.println("1");
		// bookd.select();
		boolean flag = true;
		while (flag) {
			System.out.println("""
					----------Main Menu----------
					      1. 책 입력
					      2. 입력된 책 전체 조회
					      3. 입력된 책 내용 수정
					      4. 입력된 책 삭제
					      5. 종료
					-----------------------------
					""");
			System.out.print("원하시는 메뉴를 선택해주세요>> ");
			int main_menu = sc.nextInt();
			switch (main_menu) {
			case 1 -> bookd.insert();

			case 2 -> bookd.select();

			case 3 -> {
				System.out.println("""
						----------------------------
						        등록내용 수정하기
						          1. 책 번호
						          2. 책 제목
						          3. 책 저자
						          4. 책 출판사
						          5. 책 가격
						----------------------------
						""");

				System.out.print("변경할 내용을 선택해주세요>> ");
				int change = sc.nextInt();
				switch (change) {
				case 1->{
					System.out.println("책 번호 수정...");
					System.out.print("번경하실 책의 번호를 입력>> ");
					int sbook = sc.nextInt();// 선택한 번호
					System.out.println("선택된 번호>> " + sbook);
					System.out.print("변경할 번호를 입력>> ");
					int cbook = sc.nextInt();
					bookd.updateint(change,sbook, cbook);
				}
					
				case 2->{
					System.out.println("책 제목 수정...");
					System.out.println("변경하실 책의 번호를 입력>> ");
					int sbook = sc.nextInt();
					sc.nextLine();
					System.out.println("변경하실 제목을 입력");
					String cname = sc.nextLine();
					bookd.updatestring(change, sbook, cname);
				}
					
				case 3->{
					System.out.println("책 저자 수정");
					System.out.println("변경하실 책의 번호를 입력>> ");
					int sbook = sc.nextInt();
					sc.nextLine();
					System.out.println("변경하실 내용 입력");
					String cname = sc.nextLine();
					bookd.updatestring(change, sbook, cname);
				}
					
				case 4 ->{
					System.out.println("책 출판사 수정");
					System.out.println("변경하실 책의 번호를 입력>> ");
					int sbook = sc.nextInt();
					sc.nextLine();
					System.out.println("변경하실 내용 입력");
					String cname = sc.nextLine();
					bookd.updatestring(change, sbook, cname);
				}
				case 5 ->{
					System.out.println("책 가격 수정");
					System.out.println("변경하실 책의 번호를 입력>> ");
					int sbook = sc.nextInt();
					System.out.println("변경하실 내용 입력");
					int cbook = sc.nextInt();
					bookd.updateint(change, sbook, cbook);
				}

				}
			}

			case 4 -> {
				System.out.print("삭제하실 책 번호를 입력해주세요>> ");
				int del_num = sc.nextInt();
				bookd.delete(del_num);
			}
			case 5 -> {
				System.out.println("프로그램을 종료합니다...");
				flag = false;
				break;
			}

			}
		}

	}

}
