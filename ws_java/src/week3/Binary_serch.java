package week3;

import java.util.Scanner;

public class Binary_serch {//이진탐색의 선행 과제는 정렬이다!!!
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int arr[] = new int[100];
		int n = (int) Math.floor(10.9);
		int temp = 0; 
		
		//for(i = 0)

		for (int i = 0; i < arr.length - 1; i++) {//들어오는 숫자를 오름차순으로 정렬하는 코드
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

		}
		//System.out.println(Arrays.toString(arr));

		int start = (int) Math.floor((arr.length / 2));
		int find_num = 18;
		

		while (true) {
			if (arr[start] < find_num) {// 중간 값이 찾는 수보다 작을 경우 배열 오른쪽으로 가서 또 중간값을 찾기
				start = (arr.length + start) / 2; //배열의 끝과 start를 더해서 2로 나눠서 start에 새로운 중간값을 저장
				if (arr[start] == find_num) {// 새로운 중간 값과 찾는 수가 일치하면 종료
					System.out.println("수를 찾았습니다!" + arr[start]);
					System.out.println("수의 위치: arr["+start+"]");
					break;//프로그램 종료
				} else {
					continue;//찾을때 까지 반복하기
				}

			} else {
				start = (0 + start) / 2;
				if (arr[start] == find_num) {// 새로운 중간 값과 찾는 수가 일치하면 종료
					System.out.println("수를 찾았습니다!" + arr[start]);
					System.out.println("수의 위치: arr["+start+"]");
					break;
				} else {
					continue;
				}
			}

		}

	}

}
