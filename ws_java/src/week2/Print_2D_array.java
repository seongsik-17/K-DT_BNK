package week2;

public class Print_2D_array {

	public static void main(String[] args) {
		// 2차원 배열에 12345 109876 1112131415 2019181716 2122232425 순서로 출력

		int arr[][] = new int[5][5];
		for(int i = 0; i < 5; i+=2) {
			for(int j = 0; j < 25; j++) {
				arr[i][j] = j;
			}
		}
		for(int i = 1; i <= 5; i+=2) {
			//for(int j )
		}

	}

}
