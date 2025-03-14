package week2;

import java.util.Random;
import java.util.Scanner;

public class Game_find_number_1 {

	public static void main(String[] args) {
		// 5행 5열을 만들어서 5개의 1을 랜덤으로 숨긴다
		// 사용자는 행과 열의 주소를 입력하여 배틀쉽게임
		// 다 찾으면 위치 공개
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int row = 0;//행(카디널리티)
		int column = 0; //열(차수)
		int point = 0;

		int arr[][] = new int[5][5];// 5행 5열 배열을 생성
		int clone_arr[][] = new int[5][5];

		for (int i = 0; i < 5; i++) {// 모두 0으로 채워진 배열을 생성
			for (int j = 0; j < 5; j++) {
				arr[i][j] = 0;
			}
		} // 0으로 채워진 배열 생성 종료

		for (int k = 0; k < 5; k++) {// 만들어진 배열 중에 5곳을 1로 변경
			int num1 = rd.nextInt(5);
			int num2 = rd.nextInt(5);
			arr[num1][num2] = 1;

			for (int i = 0; i < 5; i++) {// 중복 검사 후 중복 발생시 다른 좌표에 1 생성
				for (int j = 0; j < 5; j++) {
					if (arr[i][j] == arr[num1][num2]) {
						num1 = rd.nextInt(5);
						num2 = rd.nextInt(5);
					}

				}
			}
		} // 랜덤위치에 1변경하기 종료
		for(int a = 0; a < 5; a++) {
			for(int b = 0; b < 5; b++) {
				clone_arr[a][b] = arr[a][b]; 
			}
		}
		
		while(true) {
			System.out.print("행(0~4)의 좌표를 입력해주세요:");//로행
			row = sc.nextInt();
			System.out.print("열(0~4)의 좌표를 입력해주세요:");//컬열
			column = sc.nextInt();
			
			if(arr[row][column]!=1) {
				System.out.println("틀렸습니다!");
				continue;
			}
			else {
				System.out.println("해당 위치에 1이 존재합니다.");
				point = point+1;
				arr[row][column] = 0;
			}
			if(point == 5) {
				System.out.println("모든 1을 찾았습니다!");
				System.out.println("1의 위치를 표시합니다.");
				for(int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						System.out.print(clone_arr[i][j]+" ");
					}
					System.out.println("");
				}
				break;
			}
			
		}

	}

}
