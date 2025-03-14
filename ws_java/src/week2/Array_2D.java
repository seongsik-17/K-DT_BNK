package week2;

import java.util.Arrays;

public class Array_2D {

	public static void main(String[] args) {
		int a[][] = new int[3][5];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				a[i][j] = j;

			}
		}
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + " ");

			}
			System.out.println(" ");
		}

	}

}//5행/5열짜리 정수 배열 board
//프로그램이 시작되면 1이라는 숫자가 5군데에만 저장이 된다.
