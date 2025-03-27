package vo;

public class AAA {
	int n;//인스턴스 생성만큼 존재 
	public static int x;//클래스 변수는 하나만 존재 
	public static int y;//하나만 존재하기 때문에 클래스 이름으로 접근해서 사용 
	
	void nonf() {
		System.out.println("non static");
		test();
		f();
	}
	public static void f() {
		System.out.println("static");
		
	}
	void test() {
		System.out.println("test 입니다.");
	}

}
