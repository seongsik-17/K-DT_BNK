package week2;

import java.util.Scanner;

public class Test15 {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		int x = 1;
		//아스키코드는 7비트로 표현됨

		switch (x) {
		case 1:
			System.out.println("1입니다.");
			break;
		case 2:
			System.out.println("2입니다.");
			break;
		case 3:
			System.out.println("3입니다.");
			break;
		default:
			System.out.println("1도 2도 3도 아닙니다.");
			break;
		}

		char c = 'a';

		switch (c) {
		case 97:
			System.out.println("A입니다.");
			break;
		case 98:
			System.out.println("B입니다.");
			break;
		case 99:
			System.out.println("C입니다.");
			break;
		default:
			System.out.println("A도 B도 C도 아닙니다.");
			break;
		}

		String d = "철수";

		switch (d) {
		case "영희":
			System.out.println("A입니다.");
			break;
		case "철수":
			System.out.println("B입니다.");
			break;
		case "영식":
			System.out.println("C입니다.");
			break;
		default:
			System.out.println("A도 B도 C도 아닙니다.");
			break;
		}
		int a = 75;

	}

}
