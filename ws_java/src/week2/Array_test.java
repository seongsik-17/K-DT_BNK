package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Array_test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열에 넣는만큼 들어가는 코드
		int a[] = new int[3];// 3칸짜리 배열 생성
		int b[] = new int[a.length+1];
		for (int i = 0; i < a.length; i++) {//배열이 다 차지않는 선에서 배열에 저장
			a[i] = sc.nextInt();//누르는 대로 들어감
		}
		while (true) {//오버되는 부분에 대해서 지속적으로 배열을 늘려나가는 반복문
			b = new int[a.length + 1];//반복 될 때 마다 앞에 배열보다 큰 배열을 생성 
			for (int j = 0; j < a.length; j++) {//a배열과 b배열을 연동하기 위해 b에다가 a의 값을 넣는다
				b[j] = a[j];
			}
			a = b;//b의 주소값을 a에 넣는다
			a[a.length-1] = sc.nextInt();
			if(a[a.length-1] == -1) {
				break;
			}
			System.out.println(Arrays.toString(a)); 

		}
	}

}
//{} = 중괄호, 블록, 블레이스