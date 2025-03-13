package week2;

import java.util.Arrays;

public class Test12 {

	public static void main(String[] args) {

		int a[] = new int[3];// 배열 3칸 만들기
		int b[] = new int[a.length + 1];

		for (int i = 0; i < 10; i++) {// 반복해서 배열에 10 넣기
			if (i >= a.length) {// 배열에 공간이 부족할 경우
				b = new int[a.length + 1];//a를 복제할 a보다 큰  b배열을 생셩

				for (int j = 0; j < a.length; j++) {//a배열의 값을 b배열에 저장
					b[j] = a[j];
				}

				a = b;//a배열의 쥬소값에 b의 주소값을 대입

				a[i] = 10;//늘어난 자리에 10을 대입

			} else {//a배열에 자리가 부족하지 않을 경우에 10을 넣음
				a[i] = 10;
			}

			System.out.println(Arrays.toString(a));

		}

	}

}
