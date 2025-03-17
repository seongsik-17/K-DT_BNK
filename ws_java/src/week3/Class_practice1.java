package week3;

public class Class_practice1 {

	public static int add3(int n) {// 3을 더하는 함수
		int result = n + 3;
		// System.out.println(result);
		return result;
	}

	public static void f1() {// 반환값이 없는 함수 void
		System.out.println("f1함수 호출....");
	}

	public static void f2(int a) {// 정수형 자료를 입력받아 출력하는 함수
		System.out.println(a);
	}

	public static void main(String[] args) {
		add3(5);
		System.out.println(add3(5));

		f1();
		f2(3);

	}

}
