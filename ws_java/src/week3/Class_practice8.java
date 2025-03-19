package week3;

public class Class_practice8 {
	public static void f(int a, char b) {
		for (int i = 0; i < a; i++) {

			if ((i + 1) % 5 == 0) {
				System.out.print('B');
			} 
			else {
				System.out.print(b);
			}
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int n = 20;
		char x = 'A';

		f(n, x);

		System.out.println("---End---");

	}

}
