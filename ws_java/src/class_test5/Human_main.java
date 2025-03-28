package class_test5;

import java.util.Scanner;

import vo.Human;

public class Human_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력해주세요>> ");
		int a = sc.nextInt();
		
		Human H1 = new Human();
		H1.cheakAge(a);
		H1.setName("홍길동");
		H1.setAge(20);
		
		Human H2 = new Human();
		H2.setName("김철수");
		H2.setAge(199);
		
		
 		
	}

}
