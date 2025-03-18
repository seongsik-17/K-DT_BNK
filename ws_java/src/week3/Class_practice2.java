package week3;

public class Class_practice2 {
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

	public static void main(String[] args) {
		// 덧셈 뺄셈 곱셈 나눗셈을 각각 호출해서 출력 수 2개를 입력 받음
		System.out.println(add(100, 200));
		System.out.println(minus(200, 100));
		System.out.println(multi(10, 20));
		System.out.println(division(10, 5));

	}

}
