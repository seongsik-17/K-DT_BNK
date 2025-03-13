package week2;

import java.util.Scanner;

public class Hotel_reserve {

	public static void main(String[] args) {
		// 방이 10개 존재
		// 모두 공실로 시작
		// 화면에는 예약 현황을 보여준다(예약X: 0 예약O: 1123
		// 몇번 방을 예약하시겠습니까? 1 2 3 4 5 6 ....10(무한 루프)
		// 이미 예약된 방을 선택하면 이미 예약되어있다고 안내문을 보내고 재 입력을 요청
		// 10개 방이 다 차면 "만실입니다." 출력 후 종료

		Scanner sc = new Scanner(System.in);
		int sum = 0;//총 예약된 객실 수
		int room[] = new int[10];//객실

		while (true) {// break를 만날때까지 반복
			if (sum == 10) {//sum 객실을
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("만실입니다.");
				break;
			}
			System.out.print("예약 하시겠습니까? 1. 예 아무숫자: 아니오 >> ");
			int onoff = sc.nextInt();
			if(onoff != 1) {
				System.out.println("예약 시스템을 종료합니다.");
				break;
			}
			

			
			System.out.println("                              객실현황");
			System.out.println("");
			System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10");//반복문 안으로 넣기 가능(밑에 for문으로)
			System.out.println("-------------------------------------------------------------------------------");
			for (int i = 0; i < 10; i++) {
				System.out.print(room[i] + "\t");

			}
			System.out.println("");
			System.out.print("어떤 방을 예약하시겠습니까? >> ");
			int slct = sc.nextInt();			
			switch (slct) {//입력받은 호실을 조건에 맞는 배열에 저장
			case 1:
				room[0]+=1;
				break;
			case 2:
				room[1]+=1;
				break;
			case 3:
				room[2]+=1;
				break;
			case 4:
				room[3]+=1;
				break;
			case 5:
				room[4]+=1;
				break;
			case 6:
				room[5]+=1;
				break;
			case 7:
				room[6]+=1;
				break;
			case 8:
				room[7]+=1;
				break;
			case 9:
				room[8]+=1;
				break;
			case 10:
				room[9]=+1;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 처음으로 돌아갑니다.");
				continue;

			}// 객실을 선택
			for (int i = 0; i < 10; i++) {// 객실이 예약된 객실인지 확인
				if (room[i] > 1) {
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("이미 예약된 방입니다! 다시 선택해주세요");
					System.out.println("");				
					room[i]--;
					continue;
				} 
				else {
					
					System.out.println("예약이 완료되었습니다.");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("");
					sum++; 
					break;
				}
				
			}

		}

	}

}
