package week2;

import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		//점수 90 -100: A
		//점수 80 -89 : B
		//점수 70 -79 : C
		//검수 60 -69 :D
		// 59이하는 F
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력해주세요:");
		int score = sc.nextInt();
		score /=10;
		switch(score) {
		case 10: System.out.println("A"); break;
		case 9: System.out.println("A"); break;
		case 8: System.out.println("B"); break;
		case 7: System.out.println("C"); break;
		case 6: System.out.println("D"); break;
		default: System.out.println("F");
		}

	}

}
