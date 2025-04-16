package c03;

import java.util.Scanner;

public class Member {//vo클래스는 테이블과 1ㄷ1로 생성된다. (혼동을 방지하기 위해)
	private String id;
	private String pw;
	private String name;
	private String phone;
	private char grade;
	Scanner sc = new Scanner(System.in);
	Member(){
		System.out.println("회원가입을 시작합니다...");
		System.out.print("사용할 ID를 입력해주세요>> ");
		id = sc.nextLine();
		System.out.print("사용할 PW를 입력해주세요>> ");
		pw = sc.nextLine();
		System.out.print("이름을 입력해주세요>> ");
		name = sc.nextLine();
		System.out.print("전화번호를 입력해주세요>> ");
		phone = sc.nextLine();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", grade=" + grade + "]";
	}
	
	

}
