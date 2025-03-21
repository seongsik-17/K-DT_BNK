package week3;

//import java.util.Arrays;
import java.util.Scanner;

public class String_change {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = "Java is easy";
		char out[] = new char[str.length()];

		int end_cnt = 0;
		int score = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				out[i] = '*';

			} else {
				out[i] = ' ';
			}
		}

		while (true) {

			for (int j = 0; j < out.length; j++) {
				System.out.print(out[j]);
			}
			System.out.println();
			System.out.print("Call character>> ");
			int n = sc.nextInt();

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == n) {
					out[i] = str.charAt(i);
					end_cnt += 1;
					score += 10;

				} else {
					if (str.charAt(i) == 32) {
						out[i] = ' ';

					}

				}

			}

			if (end_cnt == 10) {
				System.out.println("점수>> " + score);
				System.out.println("모두 찾았습니다!");
				break;
			}

		}

	}

}
