package abstract_parctice;

import java.util.Scanner;

public class Select {
	public Select(){}
	Scanner sc = new Scanner(System.in);
	Printable bp = new BlackPrinter();
	Printable cp = new ColorPrinter();
	
	public void select(Document o) {
		while(true) {
			
			System.out.print("컬러와 흑백을 선택해주세요 흑백·컬러>> ");
			String co = sc.nextLine();
			if(co.equals("흑백") ) {
				bp.print(o);
				break;
			}
			else if(co.equals("컬러")) {
				cp.print(o);
				break;
			}
			else {
				System.out.println("잘못된 입력입니다...");
				continue;
			}
		}
		
	}
	

}
