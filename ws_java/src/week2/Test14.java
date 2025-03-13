package week2;

import java.util.Random;

public class Test14 {

	public static void main(String[] args) {
		// 주사위를 100번 굴려서 나오는 수를 카운트
		// 랜덤한 수를 100번 생성(1~6)
		// 나운 수를 저장할 배열 생성
		// 배열에서 값을 찾아 카운트
		Random rd = new Random();// Random 쿨래스를 rd로 호출

		int rec[] = new int[6];

		for (int i = 0; i < 10000; i++) {// 100번 돌린 결과를 배열에 저장
			int diceNum = rd.nextInt(6);
			switch (diceNum + 1) {
			case 1:
				rec[0]++;
				break;
			case 2:
				rec[1]++;
				break;
			case 3:
				rec[2]++;
				break;
			case 4:
				rec[3]++;
				break;
			case 5:
				rec[4]++;
				break;
			case 6:
				rec[5]++;
				break;
			default:
				break;
			}

		}
		for (int j = 0; j < 6; j++) {

			System.out.println(j + 1 + ">>" + rec[j]);
		}

	}

}
