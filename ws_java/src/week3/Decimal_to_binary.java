package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Decimal_to_binary {
	static Scanner sc = new Scanner(System.in);

	static void binary(int deci) {
		int arr[] = new int[100];
		int i = 0;
		int cnt = 0;

		while (true) {
			if (deci <= 1) {
				arr[i] = deci;
				break;
			}
			arr[i] = deci % 2;
			i++;
			deci /= 2;
			cnt += 1;

		}
		for (int j = cnt; j >= 0; j--) {
			System.out.print(arr[j]);
		}
		System.out.println("⑵");
	}

	static void octal(int deci) {
		int arr[] = new int[100];
		int i = 0;
		int cnt = 0;

		while (true) {
			if (deci < 8) {
				arr[i] = deci;
				break;
			}
			if (deci <= 1) {
				arr[i] = deci;
				break;
			}
			arr[i] = deci % 8;
			i++;
			deci /= 8;
			cnt += 1;

		}
		for (int j = cnt; j >= 0; j--) {
			System.out.print(arr[j]);
		}
		System.out.println("⑻");

	}

	static void hexa(int deci) {
		int arr[] = new int[100];
		int i = 0;
		int cnt = 0;

		while (true) {
			
			if (deci <= 1) {
				cnt--;
				break;
			}
			arr[i] = deci % 16;
			
			
			if(deci%16 > 9) {			
				
				switch(deci%16) {
				case 10: arr[i] = 65; break;
				case 11: arr[i] = 66; break;
				case 12: arr[i] = 67; break;
				case 13: arr[i] = 68; break;
				case 14: arr[i] = 69; break;
				case 15: arr[i] = 70; break;			
				
				}
			}
			i++;
			deci /= 16;
			cnt += 1;

		}
		for (int j = cnt; j >= 0; j--) {
			if(arr[j] > 64 ) {
				
				System.out.print((char)arr[0]);
			}else {
				System.out.print(arr[j]);
			}
			
		}
		System.out.println("⑵");
	}

	public static void main(String[] args) {
		// 10진수를 입력받아서 2진수로 변환하는 프로그램
		// 입력받는 수가 1일 될때 까지 나누면서 나머지를 받는다
		// 그 나머지를 역순으로 출력하면 2진수 변환 완료

		System.out.print("10진수를 입력해주세요>> ");
		int deci = sc.nextInt();

		binary(deci);
		octal(deci);
		hexa(deci);

	}

}
