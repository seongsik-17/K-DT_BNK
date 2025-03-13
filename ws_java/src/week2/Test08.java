package week2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test08 {//랜덤 숫자 맞추기 게임

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Scanner 클래스를 sc로 호출
		Random  rd = new Random();//Random 쿨래스를 rd로 호출
		
		//System.out.print("범위를 입력해주세요: ");
		int range = 10;//sc.nextInt();range변수에 입력받은 수 대입(한계설정)
		
		int arr_range = 100;
		int arr[] = new int[arr_range];
		int i = 0;
		int rdNum = rd.nextInt(range)+1;//1부터 시작하기 위해 +1
		int life = 100;//게임 목숨
		int Try = 1;//시도 횟수
		int high_score = 0;//최고점수 저장 변수
		
		int [] num = new int[10];
		num[rdNum-1] =num[rdNum]+1; 
		
		
		
		while(true) {//break;를 만나기 전까지 계속 반복
			System.out.print("숫자를 입력해주세요:");
			int scNum = sc.nextInt();//28~30: 사용자가 입력하는 숫자를 배열에 저장
			
			arr[i] = scNum;
			i++;
			 
			if(rdNum==scNum) {
				System.out.println("----------------");
				System.out.println("정답입니다!d(･∀･○)");
				System.out.println("시도 횟수:"+Try);
				System.out.println("점수:"+life);
				System.out.print("입력한 수:");
				for(int j = 0; j < (Try); j++) {//배열에 저장된 수 까지만 출력하기 위해 빈 공간은 제외시킴
					System.out.print(arr[j]+" ");//배열에 저장된 입력했던 수를 차례대로 출력
				}
				if(life > high_score) {
					high_score = life;
					System.out.println("신기록 갱신! 최고점수:"+high_score+"점");
				}
				
				//게임에서 나오는 숫자를 
				System.out.println("");
				System.out.println("게임을 계속 하시겠습니까? 1. 예 2. 아니오");
				int onoff = sc.nextInt();
				if(onoff==1) {
					rdNum = rd.nextInt(range)+1;
					life = 100;
					Try = 1;
					num[rdNum-1] =num[rdNum]+1; 
					continue;
				}
				else {
					System.out.println("          정답 숫자 누계          ");
					System.out.println("[1  2  3  4  5  6  7  8  9  10]");
					System.out.println(Arrays.toString(num));
				}					
			}
			else {
				life-=10;
				++Try;//
				if(rdNum>scNum) {//rdNum보다 입력한 값이 작으면 UP을 출력
					System.out.println("--------UP--------");
				}
				else {//rdNum보다 입력한 값이 작으면 DOWN을 출력
					System.out.println("-------DOWN-------");
				}
				System.out.println("틀렸습니다!");
			
				if(life == 0) {
					
					System.out.println("GAME OVER ㅋ.ㅋ");
					System.out.print("입력한 수: ");
					for(int j = 0; j < (Try); j++) {
						System.out.print(arr[j]+" ");
					}
					
					System.out.println("");
					System.out.println("게임을 계속 하시겠습니까? 1. 예 2. 아니오");
					int onoff = sc.nextInt();
					if(onoff==1) {
						rdNum = rd.nextInt(range)+1;
						life = 100;
						Try = 1;
						num[rdNum-1] =num[rdNum]+1; 
						continue;
					}
					else {
						for(int m = 0; m < 10; m++){
							System.out.println("1 2 3 4 5 6 7 8 9 10");
							System.out.print(num[m]+"");//각요소별 출력 횟수 집계 후 출력.
						}
							break;
					}
						
				}
			}
		}
		
		

	}

}
