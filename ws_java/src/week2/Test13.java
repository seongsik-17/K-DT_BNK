package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Test13 {

	public static void main(String[] args) {
		// 1234를 입력하면
		// 숫자를 입력받음
		// 입력한 수들의 합
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요:");
		int scNum = sc.nextInt();
		int a[] = new int[5];
		int n = 0;
		int sum = 0;

		

		for (int i = 0; i < a.length; i++) {
			a[i] = scNum % 10;// 1의 자리 구하기
			n = scNum / 10;
			scNum = n;

		}
		
		for (int j = a.length - 1; j >= 0; j--) {
			sum += a[j];
		}

		System.out.println(sum);

	}

}
