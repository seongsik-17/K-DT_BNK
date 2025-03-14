package week2;

import java.util.Scanner;

public class Score_sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int[4][4];
		int kor = 0;
		int eng = 0;
		int math = 0;
		int sumkor = 0;
		int sumeng = 0;
		int summath = 0;
		
		
		
		for(int i = 0; i < 3; i++) {
			System.out.println((i+1)+"번 학생의");
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					System.out.print("국어 성적 입력>>");
					kor = sc.nextInt();
					arr[i][j] = kor;
					sumkor +=kor; 
				}
				else if(j == 1) {
					System.out.print("영어 성적 입력>>");
					eng = sc.nextInt();
					arr[i][j] = eng;
					sumeng +=eng;
				}
				else {
					System.out.print("수학 성적 입력>>");
					math = sc.nextInt();
					
					arr[i][j] = math;
					summath+=math;
				}
				
			
			}
			arr[i][3] = kor+eng+math;
			if(i == 0) {
				arr[3][i] = sumkor;
			}
			else if(i == 1) {
				arr[3][i] = sumeng;
			}
			else {
				arr[3][i] = summath;
			}
			
		}//성적 입력 2차원 배열 완료
		for(int i = 0; i < 3; i++) {
			System.out.print((i+1)+"번 학생의 점수 총합:"+arr[i][3]+" \n");			
		}
		System.out.println(" ");
		System.out.println("국어 총합:"+arr[0][3]);
		System.out.println("영어 총합:"+arr[1][3]);
		System.out.println("수학 총합:"+arr[2][3]);
		//[0][i]의 합 구하는 반복문 구현
		

	}

}
