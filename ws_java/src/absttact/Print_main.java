package absttact;

import java.util.Scanner;

public class Print_main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Printable bp = new BlackPrinter();
		Printable cp = new ColorPrinter();
		Document o = new Document();
		
		System.out.print("출력할 내용을 입력해주세요>> ");
		String input = sc.nextLine();
		o.setA(input);
		
		System.out.print("컬러와 흑백을 선택해주세요 1.흑백 2.컬러>> ");
		int co = sc.nextInt();
		
		if(co == 1) {
			bp.print(o);
		}
		else if(co ==2) {
			cp.print(o);
		}
		else {
			System.out.println("잘못된 입력입니다...");
		}
		
		
		
		

	}

}
