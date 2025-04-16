package c02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mk_account {
	Scanner sc = new Scanner(System.in);
	private String id;
	private String pw;
	private String name;
	private String phone;
	private char grade;

	Mk_account() {

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

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}
	

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	

	@Override
	public String toString() {
		return "Mk_account\nid>> " + id+"\n" + "pw>> " + pw+"\n" + "이름>> " + name+"\n" + "전화번호>> " + phone+"\n" + "등급>> "
				+ grade;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	}
}
