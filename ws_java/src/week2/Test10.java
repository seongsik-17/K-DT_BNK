package week2;

import java.util.Random;
import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		// 가위바위보 게임 만들기
		// 컴퓨터가 낼 가위(1)바위(2)보(3) 랜덤으로 뽑기
		// 게임을 계속 반복하기
		// 승무패 전적을 계속 기록하기 win draw lose
		// 게임은 그만 할때까지
		// 게임 종료시 전적을 표시하기(대전 횟수, 승리 횟수, 패배 횟수)
		Scanner sc = new Scanner(System.in);// Scanner 클래스를 sc로 호출
		Random rd = new Random();// Random 쿨래스를 rd로 호출
		int tmp = 0;
		int win = 0;// 승리
		int lose = 0;// 패배
		int draw = 0;// 비김
		int cpu = 0;// 컴퓨터
		int usr = 0;// 사용자
		int cnt = 0;// 총 게임 횟수
		int record[] = new int[] { 0, 0, 0 };
		int max = 0;
		int max1 = 0;
		cpu = rd.nextInt(3) + 1;// 컴퓨터가 랜덤으로 가위바위보에 해당하는 숫자를 저장
		while (true) {// 게임을 원하는 때 까지 계속 반복
			// System.out.print("내가 낼 것 (1.가위 2.바위 3.보)>>");
			// usr = sc.nextInt();// 내가 입력한 숫자를 usr에 저장
			// 29-37 컴퓨터가 낸 전적을 배열에 저장
			if (cpu == 1) {
				record[0] += 1;
			} else if (cpu == 2) {
				record[1] += 1;
			} else {
				record[2] += 1;
			}
			
			for(int i = 0; i < 3; i++) {
				if(record[i]>max) {
					max = record[i];
					max1 = i+1;
					
					
				}
			}

			System.out.println("추천:" + (max1));
			System.out.print("내가 낼 것 (1.가위 2.바위 3.보)>>");
			usr = sc.nextInt();// 내가 입력한 숫자를 usr에 저장

			if (usr != 1 && usr != 2 && usr != 3) {
				System.out.println("잘못입력하셨습니다! 다시입력해주세요!");

				continue;
			}
			System.out.println("---------------------------");

			System.out.println("컴퓨터가 낸 것:" + cpu);
			System.out.println("user가 낸 것:" + usr);

			if ((cpu-usr==-1)||(cpu-usr==2)) {
				System.out.println("---------------------------");
				System.out.println("user 승리!");
				win += 1;

			} else if ((cpu-usr==-2)||(cpu-usr==1)) {
				System.out.println("---------------------------");
				System.out.println("user 패배!");
				lose += 1;
			} else {
				System.out.println("---------------------------");
				System.out.println("비김!");
				draw += 1;

			}
			cnt += 1;
			System.out.print("계속 플레이 할까요?? 1.예 2.아니오 >>");
			int ans = sc.nextInt();// 1나 2를 입력받음
			if (ans == 1) {
				System.out.println("---------------------------");
				System.out.println("게임을 계속합니다.");
				System.out.println("---------------------------");
				cpu = rd.nextInt(3) + 1;// 컴퓨터가 랜덤으로 가위바위보에 해당하는 숫자를 저장
				continue;
			} // ans == 계속
			else if (ans == 2) {
				System.out.println("게임을 종료합니다.");
				System.out.println("총 횟수:" + cnt);
				System.out.print("전적>>");
				System.out.println("승리:" + win + " 무승부:" + draw + " 패배:" + lose);
				break;
			} else {
				System.out.println("잘못 입력하셨습니다! 게임을 종료합니다.");
				System.out.println("총 횟수:" + cnt);
				System.out.print("전적>>");
				System.out.println("승리:" + win + " 무승부:" + draw + " 패배:" + lose);
				break;
			}
		}

	}

}
