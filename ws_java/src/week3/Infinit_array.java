package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Infinit_array {
	static int[] infinit(int a[]) {
		int b[] = new int[a.length + 5];// 반복 될 때 마다 앞에 배열보다 큰 배열을 생성
		for (int j = 0; j < a.length; j++) {// a배열과 b배열을 연동하기 위해 b에다가 a의 값을 넣는다
			b[j] = a[j];
		}
		a = b;// b의 주소값을 a에 넣는다

		return a;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열에 넣는만큼 들어가는 코드
		int a[] = new int[5];// 3칸짜리 배열 생성

		for (int i = 0; i < a.length+1; i++) {// 배열이 다 차지않는 선에서 배열에 저장
			System.out.print((i+1)+")숫자를 입력해주세요>> ");
			a[i] = sc.nextInt();// 누르는 대로 들어감
			//System.out.println();
			if(i == a.length-1) {
				a = infinit(a);				
			}
			if(a[i]==-1) {
				System.out.println("입력을 종료합니다...");
				break;
			}
		}

	}

}
