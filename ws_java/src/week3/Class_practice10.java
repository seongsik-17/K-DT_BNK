package week3;

import java.util.Random;
import java.util.Scanner;

public class Class_practice10 {
	static int win_cnt = 0;
	static int lose_cnt = 0;
	static int draw_cnt = 0;// 전역함수 선언

	static int random() {// 랜덤 수를 생성(1~3)
		Random rd = new Random();
		int rdNum = rd.nextInt(3) + 1;
		return rdNum;
	}

	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("내가 낼 것 (1.가위 2.바위 3.보)>>");
		int usr_in = sc.nextInt();
		System.out.println();

		return usr_in;
	}

	static void winlose(int c, int u) {
		System.out.println("컴퓨터가 낸 것 (1.가위 2.바위 3.보)>>" + c);
		if ((c - u == -1) || (c - u == 2)) {
			System.out.println("---------------------------");
			System.out.println("user 승리!");
			win_cnt += 1;

		} else if ((c - u == -2) || (c - u == 1)) {
			System.out.println("---------------------------");
			System.out.println("user 패배!");
			lose_cnt += 1;

		} else {
			System.out.println("---------------------------");
			System.out.println("비김!");
			draw_cnt += 1;

		}
	}
	

	public static void main(String[] args) {
		// 랜덤 수를 발생시키는 함수 사용(랜덤수 가져오는 함수)
		// 사용자가 입력하는 수도 함수 받음
		// 사용자가 입력한 함수랑 비교해서 누가 이겼는지 알려주는 함수(승패)
		// 메인 함수는 함수 인자만 전달하는 역할

		while (true) {

			int user = input();
			winlose(random(), user);// 가위바위보 게임
			
			if(user<0) {
				System.out.println("전적");
				System.out.println("승리:" + win_cnt + " 무승부:" + draw_cnt + " 패배:" + lose_cnt);
				break;
			}
			

		}

	}

}
