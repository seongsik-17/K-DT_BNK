package r14;

import java.util.Scanner;

public class Create_Acc {
	Scanner sc = new Scanner(System.in);
	private String name;
	private String id;
	private String pw;

	public Create_Acc() {
		System.out.print("이름을 입력해주세요>> ");
		name = sc.nextLine();
		System.out.print("사용할 아이디를 입력해주세요>> ");
		id = sc.nextLine();
		System.out.print("사용할 비밀번호를 입력해주세요>> ");
		pw = sc.nextLine();
		System.out.println("계정이 성공적으로 생성되었습니다!");

	}

	Create_Acc(String name, String id, String pw) {
		System.out.println("계정이 성공적으로 생성되었습니다!");
	}

	public void login() {
		System.out.print("Id>> ");
		String id = sc.nextLine();
		System.out.print("Pw>> ");
		String pw = sc.nextLine();
		// if()

	}

//	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
