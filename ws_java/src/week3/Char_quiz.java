package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Char_quiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char str[] = new char[] { 'J', 'a', 'v', 'a', ' ', 'i', 's', ' ', 'e', 'a', 's', 'y' };
		char out[] = new char[str.length];

		int end_cnt = 0;
		int score = 100;

		for (int i = 0; i < str.length; i++) {
			if (str[i] != ' ') {
				out[i] = '*';

			} else {
				out[i] = ' ';
			}
		}
		// System.out.println(Arrays.toString(out));

		while (true) {
			for (int j = 0; j < out.length; j++) {
				System.out.print(out[j]);
			}
			System.out.println();
			System.out.print("Call character>> ");
			int n = sc.nextInt();

			for (int i = 0; i < str.length; i++) {
				if (str[i] == n) {
					out[i] = str[i];
					end_cnt+=1;					

				} else {
					if (str[i] == 32) {
						out[i] = ' ';
					}				

				}
				
			}
			
			if(end_cnt == 10) {
				System.out.println("점수>> "+score);
				System.out.println("모두 찾았습니다!");
				break;
			}

		}

	}

}
