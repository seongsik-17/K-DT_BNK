package week3;

import java.util.Random;
import java.util.Scanner;

public class Binary_serch {// 이진탐색의 선행 과제는 정렬이다!!!
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 4, 7 };
		int n = (int) Math.floor(10.9);
		int temp = 0;
		int rdNum = 0;

		for (int i = 0; i < arr.length - 1; i++) {// 들어오는 숫자를 오름차순으로 정렬하는 코드
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

		}
		// System.out.println(Arrays.toString(arr));
		int start = 0;
		int mid = (int) Math.floor((arr.length - 1) / 2);
		int end = arr.length-1;
		int find_num = 4;

		while (true) {
			if (arr[mid] < find_num) {// 중간 값이 찾는 수보다 작을 경우 배열 오른쪽으로 가서 또 중간값을 찾기
				mid = ((arr.length - 1) + mid) / 2; // 배열의 끝과 start를 더해서 2로 나눠서 start에 새로운 중간값을 저장
				if(arr[mid] > find_num) {
					mid /= 2;
					continue;
				}			
				

			}
		}

	}

}
