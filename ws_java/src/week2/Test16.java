package week2;

import java.util.Arrays;
import java.util.Random;

public class Test16 {

	public static void main(String[] args) {
		// 로또번호 추출기
		// 숫자 범위: 1~45
		// 자리수: 6자리
		// 중복된 숫자 X
		// 상태변수
		Random rd = new Random();

		int lotto[] = new int[6];
		int rdNum = 0;

		for (int i = 0; i < 6; i++) {
			rdNum = rd.nextInt(45)+1;
			lotto[i] = rdNum;
			for(int k = 0; k < i; k++) {
				if(lotto[i]== lotto[k]) {
					lotto[i] = rd.nextInt(45)+1;
				}
			}
			
		}
		System.out.println(Arrays.toString(lotto));

	}

}
