package week3;

import java.util.Scanner;

public class Class_practice6 {

	public static int oddeven(int num) {// 홀짝 판별 함수
		if (num % 2 == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요>>");
		int num = sc.nextInt();
		if (oddeven(num) == 0) {
			System.out.println("짝수입니다...");

		} else {
			System.out.println("홀수입니다...");
		}

	}

}
//짝수 홀수 판단 0, 1 반환
//(main) 0이면 짝수라고 출력 홀수면 1이라고 판단