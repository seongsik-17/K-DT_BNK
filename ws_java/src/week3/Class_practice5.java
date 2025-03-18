package week3;

import java.util.Scanner;

public class Class_practice5 {
	public static void section(int dot) {
		for (int i = 0; i < dot; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	public static void section2(int dot, String cha) {
		for (int i = 0; i < dot; i++) {
			System.out.print(cha);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("문자가 찍힐 횟수를 입력해주세요(-1: 종료)>>");
			int dot = sc.nextInt();
			if (dot < 0) {
				System.out.println("입력을 종료합니다...");
				break;
			}
			System.out.println();

			System.out.print("찍힐 문자를 입력해주세요>>");
			String cha = sc.next();
			section2(dot, cha);

		}

	}

}
