package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		// 다 채워진 배열에 다른 값을 더 넣는 방법
		// 다른 배열을 만들어서 기존의 값을 넣고 남는 공간에 새로운 값을 넣는다.
		Scanner sc = new Scanner(System.in);
		
		int scNum = 3;//배열 크기 설정

		int a[] = new int[scNum];//설정된 크기의 배열 생성
		int b[] = new int[scNum+1];
		
		for(int i = 0; i < scNum; i++) {//생성된 배열에 원소값 넣기
			a[i] = sc.nextInt();//사용자 입력
		}

		
		while(true) {
			b = new int[scNum+1];

			
			for(int i = 0; i < scNum; i++) {
				b[i] = a[i];
			}
			
			a = b;
			System.out.print("새로 넣을 수를 입력:");
			
			a[scNum] = sc.nextInt();
			if(a[scNum]==-1) {
				break;
			}
			System.out.println(Arrays.toString(a));
			scNum+=1;
		}

	}

}
