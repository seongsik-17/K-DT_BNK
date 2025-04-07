package abstract_parctice;

import java.util.Scanner;

//하나의 클래스로부터 상속을 받고 3개의 인터페이스
public class Document {
	static Scanner sc = new Scanner(System.in);
	
	public Document() {
		
	}
	private String a;
	
	public void setA(String a) {
		this.a = a;
	}
	public String getA() {
		return a;
	}
	
	public String write() {
		System.out.println("출력할 내용을 아래에 입력해주세요▼ ");
		String input = sc.nextLine();

		while(true) {
			if(input.contains("end")) {
				System.out.println("--------------------");
				break;
				
			}
			input += "\n"+sc.nextLine();
		}
		return input;
	}
	
	

}
