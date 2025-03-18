package week3;

public class Class_practice3 {
	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}

	public static int minus(int a, int b) {
		int result = a - b;
		return result;
	}

	public static int multi(int a, int b) {
		int result = a * b;
		return result;
	}

	public static double division(int a, int b) {
		int result = a / b;
		return (double) a / b;
	}

	public static void calculator(int a, int b) {
		System.out.println(add(a, b));
		System.out.println(minus(a, b));
		System.out.println(multi(a, b));
		System.out.println(division(a, b));
	}

	public static void main(String[] args) {
		// calculator 함수를 이용
		// 미리 구현해 놓은 함수들을 이용하여
		calculator(10, 5);
		System.out.println("프로그램을 종료합니다...");
	}

}
