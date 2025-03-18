package week3;

import java.util.Scanner;

public class Class_practice4 {
	public static void f1() {
		System.out.println("f1함수 실행");
		System.out.println("---------------");
	}

	public static void f2() {
		System.out.println("f2함수 실행");
		System.out.println("---------------");
	}

	public static void section(int dot) {
		for (int i = 0; i < dot; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("숫자를 입력해주세요>>");
			int num = sc.nextInt();

			if (num < 0) {
				System.out.println("프로그램을 종료합니다...");
				break;
			} else if (num % 2 == 0) {
				f1();
			} else {
				f2();
			}
			section(10);

		}

	}

}
//숫자를 입력받음
//음수 = 종료
//짝수 = f1()실행
//홀수 = f2()실행